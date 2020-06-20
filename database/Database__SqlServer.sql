create database BookStoreData;
use BookStoreData

Create table account(
  username varchar(255) not null primary key,
  password varchar(255) not null,
  type bit not null,
  RealName nvarchar(255) not null,
  PhoneNumber varchar(255) not null,
  Email varchar(255) not null,
  Address nvarchar(255) not null
)

--Login
create procedure USP_Login @p_username varchar(255), @p_passWord varchar(255)
as
select * from account where (username=@p_userName and password=@p_passWord)
go

--Get info account
create procedure USP_GetAccountByUsername @p_username varchar(255)
as
select * from account where username=@p_username
go

--Add account
create procedure USP_AddAccount @p_username    Varchar(255),@p_password    Varchar(255),
                                @p_type        bit,          @p_RealName    NVarchar(255),
                                @p_PhoneNumber Varchar(255), @p_Email       Varchar(255),
                                @p_Address     NVarchar(255)
as
INSERT INTO Account (userName, password, type, realname, PhoneNumber, Email, Address)
VALUES (@p_username, @p_password, @p_type, @p_RealName, @p_PhoneNumber, @p_Email,@p_Address)
go

--Delete account
CREATE PROCEDURE USP_DeleteAccountByUsername  @p_username VARCHAR(255)
as
delete from Account where username=@p_username 
go

--Update account
CREATE PROCEDURE USP_UpdateAccountByUsername @p_username    Varchar(255),
                                @p_password    Varchar(255),
                                @p_type        bit,
                                @p_RealName    NVarchar(255),
                                @p_PhoneNumber Varchar(255),
                                @p_Email       Varchar(255),
                                @p_Address     NVarchar(255)
as
update Account
set password=@p_password, type=@p_type, RealName=@p_RealName, PhoneNumber=@p_PhoneNumber,
email=@p_Email, Address=@p_Address
where username=@p_username
go

EXEC USP_AddAccount @p_username='admin', 
@p_password='admin', 
@p_type=0, 
@p_RealName=N'Trần Duy Trọng', 
@p_PhoneNumber='0986269014', 
@p_Email='trong@gmail.com', 
@p_Address=N'477 Nguyễn Thái Học'

CREATE PROCEDURE USP_GetAccount 
as
select * from Account;
go

select * from account;