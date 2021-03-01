
use tea00
/* SET FOREIGN_KEY_CHECKS = 0; */
CREATE TABLE Employee (
	[id] int NOT NULL IDENTITY,
	[phone] int DEFAULT NULL,
    [name] varchar(30) NOT NULL,
    [birthday] date DEFAULT NULL,
	[timeWork] int NOT NULL,
    [level] varchar(10) NOT NULL,
    [address] varchar(30) DEFAULT NULL,
    [avatar] varchar(30) DEFAULT NULL,
     PRIMARY KEY ([id])
)  ;
CREATE TABLE Customer (
	[phone] int NOT NULL IDENTITY,
    [name] varchar(30) NOT NULL,
    [level] int DEFAULT NULL,
	[birthday] date DEFAULT NULL,
    PRIMARY KEY ([phone])
) 
CREATE TABLE Voucher (
	[code] int NOT NULL IDENTITY,
	[percent] float DEFAULT NULL,
    [time] date NOT NULL,
    [phoneNumber]int NOT NULL,
     PRIMARY KEY ([code])
    ,
	 CONSTRAINT [FX_CUSTOMER] FOREIGN KEY ([phoneNumber])
     REFERENCES Customer ([phone]) ON DELETE NO ACTION ON UPDATE NO ACTION
)  ;
CREATE INDEX [FX_CUSTOMER_idx] ON Voucher ([phoneNumber]);

CREATE TABLE Bill(
	[id] int NOT NULL IDENTITY,
    [time] date NOT NULL,
    [employeeId] int DEFAULT NULL,
    [customerId] int DEFAULT NULL,
    [codeVoucher] int  DEFAULT NULL,
    PRIMARY KEY ([id])
   ,
    CONSTRAINT [FX_DETAIL] FOREIGN KEY ([employeeId])
    REFERENCES Employee ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
   ,
    CONSTRAINT [FX_CUSTOMER_01] FOREIGN KEY ([customerId])
    REFERENCES Customer ([phone]) ON DELETE NO ACTION ON UPDATE NO ACTION
   ,
    CONSTRAINT [FX_VOUCHER_01] FOREIGN KEY ([codeVoucher])
    REFERENCES Voucher ([code]) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;
CREATE INDEX [FX_DETAIL_idx] ON Bill ([employeeId]);
CREATE INDEX [FX_CUSTOMER] ON Bill ([customerId]);
CREATE INDEX [FX_VOUCHER] ON Bill ([codeVoucher]);

CREATE TABLE Tea(
	[id] int NOT NULL IDENTITY,
    [name] varchar(30) NOT NULL,
    [price] int NOT NULL,
    [status] int NOT NULL,
    PRIMARY KEY ([id])
) 
CREATE TABLE TeaBill(
	[teaId] int NOT NULL,
    [billId] int  NOT NULL,
	[amount] int  NOT NULL,
    [price] int  NOT NULL,
    [addRequest] varchar(10) DEFAULT NULL,
    PRIMARY KEY ([teaId],[billId]),
    CONSTRAINT [FX_TEA] FOREIGN KEY ([teaId])
    REFERENCES Tea([id]),
    CONSTRAINT 	[FX_BILL] FOREIGN KEY([billId])
    REFERENCES 	Bill([id])
) 

CREATE TABLE Topping (
	[id] int NOT NULL IDENTITY,
    [price] int  NOT NULL,
	[name] varchar(50)  DEFAULT NULL,
    PRIMARY KEY ([id])
) 

CREATE TABLE TeaTopping(
	[teaId] int NOT NULL,
    [toppingId] int NOT NULL,
     PRIMARY KEY ([teaId],[toppingId]),
	CONSTRAINT [FX_TEA_01] FOREIGN KEY ([teaId])
    REFERENCES Tea([id]) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT [FX_TOPPING_01] FOREIGN KEY ([toppingId])
    REFERENCES Topping([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
) 
DROP TABLE IF EXISTS [Resource];
CREATE TABLE Resource(
	[id] int NOT NULL IDENTITY,
    [date] date NOT NULL,
    [amount] int NOT NULL,
    PRIMARY KEY ([id])
) 
CREATE TABLE TeaResource(
	[teaId] int NOT NULL,
    [resourceId] int NOT NULL,
    [amount] int NOT NULL,
    PRIMARY KEY ([teaId],[resourceId]),
    CONSTRAINT [FX_TEA_02] FOREIGN KEY ([teaId])
    REFERENCES Tea ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT [FX_RESOURCE_02] FOREIGN KEY ([resourceId])
    REFERENCES Resource ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
) 
CREATE TABLE ToppingBill(
	[toppingId] int NOT NULL,
    [billId] int NOT NULL,
	[amount] int NOT NULL,
    PRIMARY KEY ([toppingId],[billId]),
    
	CONSTRAINT fk_ToppingBill_ToppingId FOREIGN KEY ([toppingId])
    REFERENCES [Topping]([id]),
    
    CONSTRAINT 	fk_ToppingBill_billId FOREIGN KEY(billId)
    REFERENCES 	[Bill]([id])   
)


/* SET FOREIGN_KEY_CHECKS = 1; */