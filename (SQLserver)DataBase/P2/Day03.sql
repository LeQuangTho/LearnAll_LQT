/*Tạo login N01Login1
Tạo user có tên N01User cho CSGL BT1
Phân quyền Select, update cho người dùng trên bảng DSHS

tạo N01login2

tạo N01User2

iif(điều kiện, giá trị khi điều kiện đúng, giá trị khi điều kiện sai)
*/
exec sp_addlogin
		N01Login1, '123'	

exec sp_adduser
		N01Login1, N01User
grant select, update on tSach to N01User

select * from tSach

exec sp_addlogin
		N01Login2, '123'

exec sp_adduser
		N01Login2, N01User2


