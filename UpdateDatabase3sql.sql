select * from account
CREATE TABLE Account (
    username varchar(255) primary key,
    password varchar(255),
    type bit,
	RealName Nvarchar(255),
	PhoneNumber varchar(255),
    Email varchar(255),
    Address Nvarchar(255)
);
CREATE PROCEDURE USP_GetAccount 
as
select * from Account;
go;

EXEC USP_GetAccount
EXEC USP_AddAccount @p_username=admin, @p_password=admin, @p_type=0, @p_RealName=N'Trần Duy Trọng',
@p_PhoneNumber=0986269014, @p_email='trong@gmail.com', @p_address=N'477 Nguyễn Thái Học'

CREATE PROCEDURE USP_DeleteAccountByUsername  @p_username NVARCHAR(255)
as
delete from Account where username=@p_username 
go;

EXEC USP_DeleteAccountByUsername @p_username=nhantk12
EXEC USP_AddAccount @p_username=nhantk12,
@p_password=1234,@p_type=2,
@p_RealName=N'Thái Hoàng Nhân',
@p_PhoneNumber=0967635163,
@p_Email='nhantk@gmail.com',
@p_Address=N'57 Hồ Thủy'
alter table account
add primary key (username)
drop procedure USP_UpdateAccount
CREATE PROCEDURE USP_UpdateAccountByUsername @p_username    NVarchar(255),
                                @p_password    NVarchar(255),
                                @p_type        int,
                                @p_RealName    NVarchar(255),
                                @p_PhoneNumber NVarchar(255),
                                @p_Email       NVarchar(255),
                                @p_Address     NVarchar(255)
as
update Account
set password=@p_password, type=@p_type, RealName=@p_RealName, PhoneNumber=@p_PhoneNumber,
email=@p_Email, Address=@p_Address
where username=@p_username
go;

CREATE PROCEDURE USP_UpdateAccount @p_username    NVarchar(255),
                                @p_password    NVarchar(255),
                                @p_type        int,
                                @p_RealName    NVarchar(255),
                                @p_PhoneNumber NVarchar(255),
                                @p_Email       NVarchar(255),
                                @p_Address     NVarchar(255)
as
update Account
set password=@p_password, type=@p_type, RealName=@p_RealName, PhoneNumber=@p_PhoneNumber,
email=@p_Email, Address=@p_Address, username=@p_username
go;

EXEC USP_UpdateAccountByUsername @p_username='admin', 
@p_password='admin', 
@p_type=0, 
@p_RealName=N'Trần Duy Trọng', 
@p_PhoneNumber='986269014', 
@p_Email='trong@gmail.com', 
@p_Address=N'477 Nguyễn Thái Học'