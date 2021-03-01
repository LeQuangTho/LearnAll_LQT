namespace Restaurant.UserControls
{
    partial class UserControlBillHeader
    {
        /// <summary> 
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.labelName = new System.Windows.Forms.Label();
            this.labelAddress = new System.Windows.Forms.Label();
            this.labelTitle = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.labelBillNumber = new System.Windows.Forms.Label();
            this.labelRoomNumber = new System.Windows.Forms.Label();
            this.labelTimeIn = new System.Windows.Forms.Label();
            this.labelTableNumber = new System.Windows.Forms.Label();
            this.labelTimeOut = new System.Windows.Forms.Label();
            this.pictureBoxQRCode = new System.Windows.Forms.PictureBox();
            this.panel2 = new System.Windows.Forms.Panel();
            this.labelNameEmployee = new System.Windows.Forms.Label();
            this.labelNameCustomer = new System.Windows.Forms.Label();
            this.labelPhoneCustomer = new System.Windows.Forms.Label();
            this.panel3 = new System.Windows.Forms.Panel();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.panel1.SuspendLayout();
            this.flowLayoutPanel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxQRCode)).BeginInit();
            this.panel3.SuspendLayout();
            this.SuspendLayout();
            // 
            // labelName
            // 
            this.labelName.Dock = System.Windows.Forms.DockStyle.Top;
            this.labelName.Font = new System.Drawing.Font(".VnBodoniH", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelName.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.labelName.Location = new System.Drawing.Point(0, 0);
            this.labelName.Name = "labelName";
            this.labelName.Size = new System.Drawing.Size(360, 54);
            this.labelName.TabIndex = 0;
            this.labelName.Text = "Restaurant";
            this.labelName.TextAlign = System.Drawing.ContentAlignment.BottomCenter;
            // 
            // labelAddress
            // 
            this.labelAddress.Dock = System.Windows.Forms.DockStyle.Top;
            this.labelAddress.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelAddress.Location = new System.Drawing.Point(0, 54);
            this.labelAddress.Name = "labelAddress";
            this.labelAddress.Size = new System.Drawing.Size(360, 23);
            this.labelAddress.TabIndex = 2;
            this.labelAddress.Text = "ĐC: Số 3 Phố Cầu Giấy, Láng Thượng, Đống Đa, Hà Nội";
            this.labelAddress.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // labelTitle
            // 
            this.labelTitle.Dock = System.Windows.Forms.DockStyle.Top;
            this.labelTitle.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTitle.Location = new System.Drawing.Point(0, 77);
            this.labelTitle.Name = "labelTitle";
            this.labelTitle.Size = new System.Drawing.Size(360, 30);
            this.labelTitle.TabIndex = 3;
            this.labelTitle.Text = "PHIẾU THANH TOÁN";
            this.labelTitle.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.flowLayoutPanel1);
            this.panel1.Controls.Add(this.pictureBoxQRCode);
            this.panel1.Controls.Add(this.panel2);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 107);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(360, 96);
            this.panel1.TabIndex = 4;
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.Controls.Add(this.labelBillNumber);
            this.flowLayoutPanel1.Controls.Add(this.labelRoomNumber);
            this.flowLayoutPanel1.Controls.Add(this.labelTimeIn);
            this.flowLayoutPanel1.Controls.Add(this.labelTableNumber);
            this.flowLayoutPanel1.Controls.Add(this.labelTimeOut);
            this.flowLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.flowLayoutPanel1.Location = new System.Drawing.Point(111, 0);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(249, 96);
            this.flowLayoutPanel1.TabIndex = 2;
            // 
            // labelBillNumber
            // 
            this.labelBillNumber.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelBillNumber.Location = new System.Drawing.Point(3, 0);
            this.labelBillNumber.Name = "labelBillNumber";
            this.labelBillNumber.Size = new System.Drawing.Size(246, 31);
            this.labelBillNumber.TabIndex = 0;
            this.labelBillNumber.Text = "Số HĐ: 00001";
            this.labelBillNumber.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // labelRoomNumber
            // 
            this.labelRoomNumber.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelRoomNumber.Location = new System.Drawing.Point(3, 31);
            this.labelRoomNumber.Name = "labelRoomNumber";
            this.labelRoomNumber.Size = new System.Drawing.Size(75, 31);
            this.labelRoomNumber.TabIndex = 1;
            this.labelRoomNumber.Text = "Phòng: A";
            this.labelRoomNumber.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // labelTimeIn
            // 
            this.labelTimeIn.Location = new System.Drawing.Point(84, 31);
            this.labelTimeIn.Name = "labelTimeIn";
            this.labelTimeIn.Size = new System.Drawing.Size(161, 31);
            this.labelTimeIn.TabIndex = 2;
            this.labelTimeIn.Text = "G.vào: 22/03/2020 12:14:59";
            this.labelTimeIn.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // labelTableNumber
            // 
            this.labelTableNumber.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTableNumber.Location = new System.Drawing.Point(3, 62);
            this.labelTableNumber.Name = "labelTableNumber";
            this.labelTableNumber.Size = new System.Drawing.Size(75, 31);
            this.labelTableNumber.TabIndex = 3;
            this.labelTableNumber.Text = "Bàn: 1";
            this.labelTableNumber.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // labelTimeOut
            // 
            this.labelTimeOut.Location = new System.Drawing.Point(84, 62);
            this.labelTimeOut.Name = "labelTimeOut";
            this.labelTimeOut.Size = new System.Drawing.Size(161, 31);
            this.labelTimeOut.TabIndex = 4;
            this.labelTimeOut.Text = "Giờ ra: 22/03/2020 23:59:59";
            this.labelTimeOut.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // pictureBoxQRCode
            // 
            this.pictureBoxQRCode.Dock = System.Windows.Forms.DockStyle.Left;
            this.pictureBoxQRCode.Location = new System.Drawing.Point(15, 0);
            this.pictureBoxQRCode.Name = "pictureBoxQRCode";
            this.pictureBoxQRCode.Size = new System.Drawing.Size(96, 96);
            this.pictureBoxQRCode.TabIndex = 1;
            this.pictureBoxQRCode.TabStop = false;
            // 
            // panel2
            // 
            this.panel2.Dock = System.Windows.Forms.DockStyle.Left;
            this.panel2.Location = new System.Drawing.Point(0, 0);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(15, 96);
            this.panel2.TabIndex = 0;
            // 
            // labelNameEmployee
            // 
            this.labelNameEmployee.Dock = System.Windows.Forms.DockStyle.Top;
            this.labelNameEmployee.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelNameEmployee.Location = new System.Drawing.Point(0, 203);
            this.labelNameEmployee.Name = "labelNameEmployee";
            this.labelNameEmployee.Size = new System.Drawing.Size(360, 30);
            this.labelNameEmployee.TabIndex = 5;
            this.labelNameEmployee.Text = "Tên NV: ";
            this.labelNameEmployee.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // labelNameCustomer
            // 
            this.labelNameCustomer.Dock = System.Windows.Forms.DockStyle.Top;
            this.labelNameCustomer.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelNameCustomer.Location = new System.Drawing.Point(0, 233);
            this.labelNameCustomer.Name = "labelNameCustomer";
            this.labelNameCustomer.Size = new System.Drawing.Size(360, 30);
            this.labelNameCustomer.TabIndex = 6;
            this.labelNameCustomer.Text = "Tên KH: ";
            this.labelNameCustomer.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // labelPhoneCustomer
            // 
            this.labelPhoneCustomer.Dock = System.Windows.Forms.DockStyle.Top;
            this.labelPhoneCustomer.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelPhoneCustomer.Location = new System.Drawing.Point(0, 263);
            this.labelPhoneCustomer.Name = "labelPhoneCustomer";
            this.labelPhoneCustomer.Size = new System.Drawing.Size(360, 30);
            this.labelPhoneCustomer.TabIndex = 7;
            this.labelPhoneCustomer.Text = "SĐT KH: ";
            this.labelPhoneCustomer.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.label4);
            this.panel3.Controls.Add(this.label3);
            this.panel3.Controls.Add(this.label2);
            this.panel3.Controls.Add(this.label1);
            this.panel3.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel3.Location = new System.Drawing.Point(0, 293);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(360, 32);
            this.panel3.TabIndex = 8;
            // 
            // label1
            // 
            this.label1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label1.Dock = System.Windows.Forms.DockStyle.Left;
            this.label1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(0, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(141, 32);
            this.label1.TabIndex = 0;
            this.label1.Text = "Món Ăn";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // label2
            // 
            this.label2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label2.Dock = System.Windows.Forms.DockStyle.Left;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(141, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(48, 32);
            this.label2.TabIndex = 1;
            this.label2.Text = "SL";
            this.label2.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // label3
            // 
            this.label3.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label3.Dock = System.Windows.Forms.DockStyle.Left;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(189, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(76, 32);
            this.label3.TabIndex = 2;
            this.label3.Text = "Đơn giá";
            this.label3.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // label4
            // 
            this.label4.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label4.Dock = System.Windows.Forms.DockStyle.Left;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(265, 0);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(95, 32);
            this.label4.TabIndex = 3;
            this.label4.Text = "Tổng Tiền";
            this.label4.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // UserControlBillHeader
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(237)))), ((int)(((byte)(241)))), ((int)(((byte)(246)))));
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.labelPhoneCustomer);
            this.Controls.Add(this.labelNameCustomer);
            this.Controls.Add(this.labelNameEmployee);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.labelTitle);
            this.Controls.Add(this.labelAddress);
            this.Controls.Add(this.labelName);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(102)))), ((int)(((byte)(120)))), ((int)(((byte)(201)))));
            this.Name = "UserControlBillHeader";
            this.Size = new System.Drawing.Size(360, 325);
            this.Load += new System.EventHandler(this.UserControlBillTitle_Load);
            this.panel1.ResumeLayout(false);
            this.flowLayoutPanel1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxQRCode)).EndInit();
            this.panel3.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label labelName;
        private System.Windows.Forms.Label labelAddress;
        private System.Windows.Forms.Label labelTitle;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.Label labelBillNumber;
        private System.Windows.Forms.Label labelRoomNumber;
        private System.Windows.Forms.Label labelTimeIn;
        private System.Windows.Forms.Label labelTableNumber;
        private System.Windows.Forms.Label labelTimeOut;
        private System.Windows.Forms.PictureBox pictureBoxQRCode;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Label labelNameEmployee;
        private System.Windows.Forms.Label labelNameCustomer;
        private System.Windows.Forms.Label labelPhoneCustomer;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
    }
}
