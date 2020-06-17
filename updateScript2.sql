use cnpm2020;
select * from Account;
create procedure USP_AddAccount @p_username    NVarchar(255),
                                @p_password    NVarchar(255),
                                @p_type        int,
                                @p_RealName    NVarchar(255),
                                @p_PhoneNumber NVarchar(255),
                                @p_Email       NVarchar(255),
                                @p_Address     NVarchar(255)
as
INSERT INTO Account (userName, password, type, realname, PhoneNumber, Email, Address)
VALUES (@p_username, @p_password, @p_type, @p_RealName, @p_PhoneNumber, @p_Email,@p_Address)
go;

EXEC USP_AddAccount @p_username  = test  ,
                    @p_password  = 123 ,
                    @p_type      = 2 ,
                    @p_RealName  = N'Nguyễn Văn A'  ,
                    @p_PhoneNumber=0986269000 ,
                    @p_Email      = test@gmail.com,
                    @p_Address    = 4/2 Hồ Thị Kỷ;
Delete  from Account where username ='test';





                                                                 
																 
















