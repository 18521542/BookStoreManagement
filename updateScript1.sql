select * from account;

create procedure USP_Login @p_username NCHAR(30), @p_passWord NCHAR(30)
as
select * from account where (username=@p_userName and password=@p_passWord)
go;


create procedure USP_GetAccountByUsername @p_username NCHAR(30)
as
select * from account where username=@p_username
go;

exec USP_GetAccountByUsername @p_username= 'admin';