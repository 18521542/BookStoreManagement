-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th7 22, 2020 lúc 03:13 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bookstoremanagement`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddAccount` (IN `p_username` VARCHAR(255), IN `p_password` VARCHAR(255), IN `p_type` INT, IN `p_RealName` VARCHAR(255), IN `p_PhoneNumber` VARCHAR(255), IN `p_Email` VARCHAR(255), IN `p_Address` VARCHAR(255))  BEGIN
INSERT INTO Account (username, password, type, realname, PhoneNumber, Email, Address)
VALUES (p_username,p_password, p_type, p_RealName, p_PhoneNumber, p_Email,p_Address);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddAuthor` (`author` VARCHAR(100))  BEGIN
	insert TACGIA(TenTacGia) values(author);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddBill` (`dateInput` DATE, `money` FLOAT, `moneyReceive` FLOAT, `moneyChange` FLOAT, `customerID` INT)  BEGIN
	insert HOADON(MaKhachHang,NgayLap,TongTien,ThanhToan,ConLai)
    values(customerID,dateInput,money,moneyReceive,moneyChange);
    update KHACHHANG set SoTienNo=SoTienNo+moneyChange where MaKhachHang=customerID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddBillInfo` (`bookID` INT, `countt` INT, `price` FLOAT, `total` FLOAT)  BEGIN
	declare id int;
    set id=(select max(SoHoaDon) from HOADON);
	insert CT_HOADON values(id,bookID,countt,price,total);
    update SACH set SoLuongTon=SoLuongTon-countt where MaSach=bookID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddBook` (`name` NVARCHAR(100), `categoryID` INT, `publishCompany` NVARCHAR(200), `publishYear` INT)  BEGIN
	insert SACH(TenSach,MaTheLoai,NhaXuatBan,NamXuatBan,SoLuongTon,DonGiaNhap)
    values(name,categoryID,publishCompany,publishYear,0,0);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddBookAuthor` (`authorID` INT)  BEGIN
	declare bookID int;
    set bookID=(select max(MaSach) from SACH);
	insert CT_TACGIA values(bookID,authorID);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddCategory` (`categoryName` VARCHAR(100))  BEGIN
if((select count(*) from THELOAISACH where TenTheLoai=categoryname)=0)
then
    insert THELOAISACH(TenTheLoai) values(categoryName);
    end if;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddCustomer` (`name` NVARCHAR(100), `phone` VARCHAR(100), `email` VARCHAR(100), `address` NVARCHAR(100))  BEGIN
	insert KHACHHANG(TenKhachHang,DiaChi,SoDienThoai,Email,SoTienNo) 
    values(name,address,phone,email,0);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddImportBook` (`dateInput` DATE, `money` FLOAT)  BEGIN
	insert PHIEUNHAPSACH(NgayLap,TongTien)values(dateInput,money);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddImportBookInfo` (`bookID` INT, `countt` INT, `price` FLOAT, `total` FLOAT)  BEGIN
	declare id int;
    set id=(select max(SoPhieuNhap) from PHIEUNHAPSACH);
	insert CT_PHIEUNHAPSACH values(id,bookID,countt,price,total);
    update SACH set SoLuongTon=SoLuongTon+countt,DonGiaNhap=price where MaSach=bookID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AddPayment` (IN `dateInput` DATE, IN `money` FLOAT, IN `customerID` INT)  BEGIN
	insert Phieuthutien(MaKhachHang,NgayLap,TienThu)
    values(customerID, dateInput, money);
    
    update KHACHHANG set SoTienNo=SoTienNo-money where MaKhachHang=customerID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_DeleteAccountByUsername` (`p_username` VARCHAR(255))  BEGIN
DELETE  from account where account.username=p_username;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_FreshReportInventory` (`month` INT, `year` INT)  BEGIN
	delete from BAOCAOTON where Thang=month and Nam=year;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_FreshReportRevenue` (`month` INT, `year` INT)  BEGIN
	delete from BAOCAODOANHTHU where Thang=month and Nam=year;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetAccount` ()  BEGIN
select * from account;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetAccountByUsername` (IN `p_userName` VARCHAR(100))  BEGIN
select * from BookStoreManagement.account where account.username=p_userName;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetAuthor` ()  BEGIN
select * from TACGIA;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetAuthorByBook` (`bookID` INT)  BEGIN
select TACGIA.MaTacGia,TACGIA.TenTacGia from TACGIA,CT_TACGIA,SACH
where TACGIA.MaTacGia=CT_TACGIA.MaTacGia and CT_TACGIA.MaSach=SACH.MaSach and SACH.MaSach=bookID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetBillByBillID` (`billID` INT)  BEGIN
	select h.SoHoaDon,h.MaKhachHang,h.NgayLap,h.TongTien,h.ThanhToan,h.ConLai,ct.MaSach,ct.SoLuong,ct.DonGiaBan,ct.ThanhTien
    from HOADON h,CT_HOADON ct
    where h.SoHoaDon=ct.SoHoaDon and h.SoHoaDon=billID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetBillByCustomerID` (`customerID` INT)  BEGIN
	select h.SoHoaDon,h.MaKhachHang,h.NgayLap,h.TongTien,h.ThanhToan,h.ConLai,ct.MaSach,ct.SoLuong,ct.DonGiaBan,ct.ThanhTien
    from HOADON h,CT_HOADON ct
    where h.SoHoaDon=ct.SoHoaDon and h.MaKhachHang=customerID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetBook` ()  BEGIN
	select* from SACH;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetBookByID` (`bookID` INT)  BEGIN
	select * from SACH where MaSach=bookID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetCategory` ()  BEGIN
select * from THELOAISACH;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetCategoryByBook` (`bookID` INT)  BEGIN
select THELOAISACH.MaTheLoai,THELOAISACH.TenTheLoai from THELOAISACH,SACH
where THELOAISACH.MaTheLoai=SACH.MaTheLoai and SACH.MaSach=bookID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetCategoryByID` (`categoryID` INT)  BEGIN
	select* from THELOAISACH where MaTheLoai=categoryID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetCustomer` ()  BEGIN
select * from KHACHHANG;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetCustomerByID` (`customerID` INT)  BEGIN
	select * from KHACHHANG where MaKhachHang=customerID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetImporByBookID` (`bookID` INT)  BEGIN
	select p.SoPhieuNhap,p.NgayLap,p.TongTien,ct.MaSach,ct.DonGiaNhap,ct.SoLuongNhap,ct.ThanhTien
    from PHIEUNHAPSACH p,CT_PHIEUNHAPSACH ct
    where p.SoPhieuNhap=ct.SoPhieuNhap and ct.MaSach=bookID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetReportInventory` (`month` INT, `year` INT)  BEGIN
	select * from BAOCAOTON where Thang=month and Nam=year;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_GetReportRevenue` (`month` INT, `year` INT)  BEGIN
	select * from BAOCAODOANHTHU where Thang=month and Nam=year;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ImportReportInventory` (`month` INT, `year` INT, `bookID` INT)  BEGIN
	declare preMonth int;
    declare preYear int;
    declare first int;
    declare incurred int;
    declare last int;
		if(month =1)
		then
			set preMonth=12;
			set preYear=year-1;
		else
			set preMonth=month-1;
			set preYear=year;
		end if;
        
        if((select count(*) from BAOCAOTON where Thang=preMonth and Nam=preYear and MaSach=bookID)>0)
        then
			set first=(select TonCuoi from BAOCAOTON where Thang=preMonth and Nam=preYear and MaSach=bookID);
        else
			set first=0;
		end if;
        if((select count(*) from CT_PHIEUNHAPSACH ct,PHIEUNHAPSACH p
			where MaSach=bookID and ct.SoPhieuNhap=p.SoPhieuNhap and month(p.NgayLap)=month and year(p.NgayLap)=year)>0)
        then
			set incurred=(select sum(ct.SoLuongNhap) from CT_PHIEUNHAPSACH ct,PHIEUNHAPSACH p 
				where MaSach=bookID and ct.SoPhieuNhap=p.SoPhieuNhap and month(p.NgayLap)=month and year(p.NgayLap)=year);
        else
			set incurred=0;
		end if;
        
        if((select count(*) from CT_HOADON ct,HOADON h
			where MaSach=bookID and ct.SoHoaDon=h.SoHoaDon and month(h.NgayLap)=month and year(h.NgayLap)=year)>0)
        then
			set last=first+incurred-(select sum(ct.SoLuong) from CT_HOADON ct,HOADON h 
										where MaSach=bookID and ct.SoHoaDon=h.SoHoaDon and month(h.NgayLap)=month and year(h.NgayLap)=year);
		else
			set last=first+incurred;
        end if;
        insert BAOCAOTON values(
			month,
			year,
			bookID,
			first,
			incurred,
			last
		);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_ImportReportRevenue` (`month` INT, `year` INT, `bookID` INT)  BEGIN
	declare count int;
    declare money float;
    if((select count(*) from CT_HOADON ct,HOADON h 
		where MaSach=bookID and ct.SoHoaDon=h.SoHoaDon and month(h.NgayLap)=month and year(h.NgayLap)=year)>0)
    then
		set count=(select sum(ct.SoLuong) from CT_HOADON ct,HOADON h
        where MaSach=bookID and ct.SoHoaDon=h.SoHoaDon and month(h.NgayLap)=month and year(h.NgayLap)=year);
        set money=(select sum(ct.ThanhTien) from CT_HOADON ct,HOADON h
        where MaSach=bookID and ct.SoHoaDon=h.SoHoaDon and month(h.NgayLap)=month and year(h.NgayLap)=year);
	else
		set count=0;
        set money=0;
	end if;
    
    insert BAOCAODOANHTHU values(
		month,
        year,
        bookID,
        count,
        money
    );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_Login` (IN `p_userName` VARCHAR(100), IN `p_passWord` VARCHAR(100))  BEGIN
select * from BookStoreManagement.account where username=p_userName and PASSWORD=p_passWord;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_UpdateAccountByUsername` (IN `p_username` VARCHAR(255), IN `p_password` VARCHAR(255), IN `p_type` INT, IN `p_RealName` VARCHAR(255), IN `p_PhoneNumber` VARCHAR(255), IN `p_Email` VARCHAR(255), IN `p_Address` VARCHAR(255))  BEGIN
 UPDATE account
 SET account.PASSWORD=p_password, account.type=p_type,
 account.RealName= p_RealName, account.PhoneNumber=p_PhoneNumber, account.Email=p_Email, account.Address=p_Address
 
 WHERE account.username=p_username;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_UpdateBook` (`id` INT, `name` NVARCHAR(100), `categoryID` INT, `publishCompany` NVARCHAR(200), `publishYear` INT)  BEGIN
	update SACH 
    set TenSach=name,MaTheLoai=categoryID,NhaXuatBan=publishCompany,NamXuatBan=publishYear
    where MaSach=id;
    
    delete from CT_TACGIA where MaSach=id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_UpdateBookAuthor` (`bookID` INT, `authorID` INT)  BEGIN
	insert CT_TACGIA values(bookID,authorID);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_UpdateCusTomer` (`customerID` INT, `name` NVARCHAR(100), `phone` VARCHAR(100), `email` VARCHAR(100), `address` NVARCHAR(100))  BEGIN
	update KHACHHANG 
    set TenKhachHang=name,SoDienThoai=phone,Email=email,DiaChi=address
    where MaKhachHang=customerID;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `username` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `type` int(255) NOT NULL,
  `RealName` varchar(255) NOT NULL,
  `PhoneNumber` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`username`, `PASSWORD`, `type`, `RealName`, `PhoneNumber`, `Email`, `Address`) VALUES
('admin', 'admin', 0, 'Trần Duy Trọng', '0986269014', 'trong@gmail.com', '47 Đinh Tiên Hoàng'),
('admin2', 'admin', 1, 'Trần Duy Trọng', '0986269014', 'trong@gmail.com', '47 Đinh Tiên Hoàng'),
('test1', 'admin', 1, 'Nguyễn Phú Quốc', '0986269014', 'trong@gmail.com', '47 Đinh Tiên Hoàng'),
('TrinhQn123', '123', 1, 'Hahaha', '0986269014', 'trong@gmail.com', '47 Đinh Tiên Hoàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baocaodoanhthu`
--

CREATE TABLE `baocaodoanhthu` (
  `Thang` int(11) NOT NULL,
  `Nam` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `SoLuongBan` int(11) DEFAULT NULL,
  `TongTien` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `baocaodoanhthu`
--

INSERT INTO `baocaodoanhthu` (`Thang`, `Nam`, `MaSach`, `SoLuongBan`, `TongTien`) VALUES
(0, 0, 1, 0, 0),
(0, 0, 2, 0, 0),
(0, 0, 3, 0, 0),
(5, 2019, 1, 0, 0),
(5, 2019, 2, 0, 0),
(5, 2019, 3, 0, 0),
(5, 2020, 1, 0, 0),
(5, 2020, 2, 0, 0),
(5, 2020, 3, 0, 0),
(5, 2020, 7, 0, 0),
(5, 2020, 8, 0, 0),
(6, 2019, 1, 0, 0),
(6, 2019, 2, 0, 0),
(6, 2019, 3, 0, 0),
(6, 2020, 1, 4, 48000),
(6, 2020, 2, 0, 0),
(6, 2020, 3, 0, 0),
(6, 2020, 7, 0, 0),
(6, 2020, 8, 0, 0),
(7, 2020, 1, 6, 168000),
(7, 2020, 2, 8, 108000),
(7, 2020, 3, 4, 91200),
(7, 2020, 7, 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baocaoton`
--

CREATE TABLE `baocaoton` (
  `Thang` int(11) NOT NULL,
  `Nam` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `TonDau` int(11) NOT NULL DEFAULT 0,
  `PhatSinh` int(11) NOT NULL DEFAULT 0,
  `TonCuoi` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `baocaoton`
--

INSERT INTO `baocaoton` (`Thang`, `Nam`, `MaSach`, `TonDau`, `PhatSinh`, `TonCuoi`) VALUES
(0, 0, 1, 0, 0, 0),
(0, 0, 2, 0, 0, 0),
(0, 0, 3, 0, 0, 0),
(0, 0, 7, 0, 0, 0),
(1, 2020, 1, 0, 0, 0),
(1, 2020, 2, 0, 0, 0),
(1, 2020, 3, 0, 0, 0),
(1, 2020, 7, 0, 0, 0),
(4, 2019, 1, 0, 0, 0),
(5, 2019, 1, 0, 0, 0),
(5, 2019, 2, 0, 0, 0),
(5, 2019, 3, 0, 0, 0),
(5, 2020, 1, 0, 0, 0),
(5, 2020, 2, 0, 0, 0),
(5, 2020, 3, 0, 0, 0),
(5, 2020, 7, 0, 0, 0),
(6, 2019, 1, 0, 0, 0),
(6, 2019, 2, 0, 0, 0),
(6, 2019, 3, 0, 0, 0),
(6, 2020, 1, 0, 5, 1),
(6, 2020, 2, 0, 0, 0),
(6, 2020, 3, 0, 0, 0),
(6, 2020, 7, 0, 0, 0),
(7, 2019, 1, 0, 0, 0),
(7, 2019, 2, 0, 0, 0),
(7, 2020, 1, 1, 20, 15),
(7, 2020, 2, 0, 11, 3),
(7, 2020, 3, 0, 36, 32),
(7, 2020, 7, 0, 6, 6),
(7, 2020, 8, 0, 13, 13);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_hoadon`
--

CREATE TABLE `ct_hoadon` (
  `SoHoaDon` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL DEFAULT 0,
  `DonGiaBan` float NOT NULL DEFAULT 0,
  `ThanhTien` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ct_hoadon`
--

INSERT INTO `ct_hoadon` (`SoHoaDon`, `MaSach`, `SoLuong`, `DonGiaBan`, `ThanhTien`) VALUES
(1, 1, 4, 12000, 48000),
(2, 1, 1, 36000, 36000),
(3, 2, 1, 24000, 24000),
(4, 1, 1, 36000, 36000),
(5, 2, 2, 12000, 24000),
(6, 1, 2, 24000, 48000),
(6, 2, 3, 12000, 36000),
(6, 3, 1, 12000, 12000),
(7, 3, 2, 26400, 52800),
(8, 2, 2, 12000, 24000),
(8, 3, 1, 26400, 26400),
(9, 1, 2, 24000, 48000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_phieunhapsach`
--

CREATE TABLE `ct_phieunhapsach` (
  `SoPhieuNhap` int(11) NOT NULL,
  `MaSach` int(11) NOT NULL,
  `SoLuongNhap` int(11) NOT NULL DEFAULT 0,
  `DonGiaNhap` float NOT NULL DEFAULT 0,
  `ThanhTien` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ct_phieunhapsach`
--

INSERT INTO `ct_phieunhapsach` (`SoPhieuNhap`, `MaSach`, `SoLuongNhap`, `DonGiaNhap`, `ThanhTien`) VALUES
(1, 1, 2, 10000, 20000),
(2, 1, 1, 10000, 10000),
(3, 1, 2, 30000, 60000),
(4, 2, 3, 10000, 30000),
(5, 2, 2, 20000, 40000),
(6, 2, 2, 10000, 20000),
(9, 3, 2, 10000, 20000),
(12, 1, 10, 10000, 100000),
(13, 1, 10, 20000, 200000),
(14, 2, 3, 20000, 60000),
(14, 3, 4, 22000, 88000),
(15, 2, 1, 10000, 10000),
(16, 3, 30, 10000, 300000),
(16, 7, 6, 110000, 660000),
(17, 8, 11, 100000, 1100000),
(18, 8, 2, 100000, 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ct_tacgia`
--

CREATE TABLE `ct_tacgia` (
  `MaSach` int(11) NOT NULL,
  `MaTacGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `ct_tacgia`
--

INSERT INTO `ct_tacgia` (`MaSach`, `MaTacGia`) VALUES
(1, 1),
(1, 3),
(1, 10),
(2, 2),
(2, 3),
(2, 4),
(3, 1),
(3, 3),
(7, 13),
(8, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `SoHoaDon` int(11) NOT NULL,
  `MaKhachHang` int(11) NOT NULL,
  `NgayLap` date NOT NULL DEFAULT current_timestamp(),
  `TongTien` float NOT NULL DEFAULT 0,
  `ThanhToan` float NOT NULL DEFAULT 0,
  `ConLai` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`SoHoaDon`, `MaKhachHang`, `NgayLap`, `TongTien`, `ThanhToan`, `ConLai`) VALUES
(1, 1, '2020-06-29', 48000, 30000, 48000),
(2, 1, '2020-07-10', 36000, 36000, 36000),
(3, 1, '2020-07-10', 24000, 0, 24000),
(4, 2, '2020-07-12', 36000, 0, 36000),
(5, 3, '2020-07-12', 24000, 24000, 0),
(6, 2, '2020-07-12', 96000, 96000, 0),
(7, 5, '2020-07-14', 52800, 10000, 42800),
(8, 5, '2020-07-14', 50400, 12000, 38400),
(9, 1, '2020-07-15', 48000, 0, 48000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKhachHang` int(11) NOT NULL,
  `TenKhachHang` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT ' ',
  `DiaChi` varchar(200) CHARACTER SET utf8 NOT NULL DEFAULT ' ',
  `SoDienThoai` varchar(11) NOT NULL DEFAULT ' ',
  `Email` varchar(100) NOT NULL DEFAULT ' ',
  `SoTienNo` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`MaKhachHang`, `TenKhachHang`, `DiaChi`, `SoDienThoai`, `Email`, `SoTienNo`) VALUES
(1, 'Duy Trọng', 'Hồ Chí Minh', '0867234190', 'Trong2000@gmail.com', 0),
(2, 'Nguyễn Văn A', '477 Nguyễn Chí Thanh', '0987567289', 'thanh@gmail.com', 0),
(3, 'Hoàng Nhân', '477/80 Đinh Lý', '012932193', 'uit@gmail.com', 0),
(4, 'Nguyễn Hoàng', 'Hồ Chí Minh', '0867234190', 'Trong2000@gmail.com', 0),
(5, 'Nguyễn Thị Kim Yến', 'Hồ Chí Minh', '0982848991', 'YenNguyen@gmail.com', 38400),
(6, 'Trần Văn Duy', 'Hồ Chí Minh', '0982842992', 'Duy2345@gmail.com', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhapsach`
--

CREATE TABLE `phieunhapsach` (
  `SoPhieuNhap` int(11) NOT NULL,
  `NgayLap` date NOT NULL DEFAULT current_timestamp(),
  `TongTien` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phieunhapsach`
--

INSERT INTO `phieunhapsach` (`SoPhieuNhap`, `NgayLap`, `TongTien`) VALUES
(1, '2020-06-29', 20000),
(2, '2020-06-29', 10000),
(3, '2020-06-29', 60000),
(4, '2020-07-10', 30000),
(5, '2020-07-10', 40000),
(6, '2020-07-12', 20000),
(9, '2020-07-12', 20000),
(12, '2020-07-12', 100000),
(13, '2020-07-12', 200000),
(14, '2020-07-14', 148000),
(15, '2020-07-14', 10000),
(16, '2020-07-15', 960000),
(17, '2020-07-15', 1100000),
(18, '2020-07-15', 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuthutien`
--

CREATE TABLE `phieuthutien` (
  `SoPhieuThu` int(11) NOT NULL,
  `MaKhachHang` int(11) DEFAULT NULL,
  `NgayLap` date NOT NULL DEFAULT current_timestamp(),
  `TienThu` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phieuthutien`
--

INSERT INTO `phieuthutien` (`SoPhieuThu`, `MaKhachHang`, `NgayLap`, `TienThu`) VALUES
(1, 1, '0000-00-00', 10000),
(2, 1, '2020-07-12', 10000),
(3, 1, '2020-07-13', 88000),
(4, 2, '2020-07-14', 20000),
(5, 5, '2020-07-14', 42800),
(6, 2, '2020-07-15', 16000),
(7, 1, '2020-07-15', 48000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

CREATE TABLE `sach` (
  `MaSach` int(11) NOT NULL,
  `TenSach` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `MaTheLoai` int(11) NOT NULL,
  `NhaXuatBan` varchar(100) CHARACTER SET utf8 NOT NULL,
  `NamXuatBan` int(11) NOT NULL,
  `SoLuongTon` int(11) NOT NULL DEFAULT 0,
  `DonGiaNhap` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `MaTheLoai`, `NhaXuatBan`, `NamXuatBan`, `SoLuongTon`, `DonGiaNhap`) VALUES
(1, 'Tình yêu ', 3, '123', 123, 15, 20000),
(2, 'Machine Learning', 1, 'Thanh Niên', 2018, 3, 10000),
(3, 'doraemon', 1, 'Kim Đồng', 2018, 32, 10000),
(7, 'Không gia đình', 5, 'Kim Đồng', 1878, 6, 110000),
(8, 'Đắc nhân tâm', 2, 'Pháp', 1890, 13, 100000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tacgia`
--

CREATE TABLE `tacgia` (
  `MaTacGia` int(11) NOT NULL,
  `TenTacGia` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tacgia`
--

INSERT INTO `tacgia` (`MaTacGia`, `TenTacGia`) VALUES
(1, 'Hoàng Nhân'),
(2, 'Johnny'),
(3, 'Duy Trọng'),
(4, 'Ngô hiếu'),
(5, 'Jisoo'),
(9, 'Ngô Thành Đông'),
(10, 'Nguyễn Nhật Ánh'),
(11, 'Phú Quốc '),
(12, 'Nguyễn Phú Quốc'),
(13, 'Hector Malot');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloaisach`
--

CREATE TABLE `theloaisach` (
  `MaTheLoai` int(11) NOT NULL,
  `TenTheLoai` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `theloaisach`
--

INSERT INTO `theloaisach` (`MaTheLoai`, `TenTheLoai`) VALUES
(1, 'Viễn Tưởng'),
(2, 'Khoa học'),
(3, 'Lãng mạn'),
(4, 'Lập trình'),
(5, 'Phiêu lưu'),
(6, 'Trẻ em '),
(7, 'gaming');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `baocaodoanhthu`
--
ALTER TABLE `baocaodoanhthu`
  ADD PRIMARY KEY (`Thang`,`Nam`,`MaSach`),
  ADD KEY `BAOCAODOANHTHU_SACH_FK` (`MaSach`);

--
-- Chỉ mục cho bảng `baocaoton`
--
ALTER TABLE `baocaoton`
  ADD PRIMARY KEY (`Thang`,`Nam`,`MaSach`),
  ADD KEY `BAOCAOTON_SACH_FK` (`MaSach`);

--
-- Chỉ mục cho bảng `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  ADD PRIMARY KEY (`SoHoaDon`,`MaSach`),
  ADD KEY `CT_HOADON_SACH_FK` (`MaSach`);

--
-- Chỉ mục cho bảng `ct_phieunhapsach`
--
ALTER TABLE `ct_phieunhapsach`
  ADD PRIMARY KEY (`SoPhieuNhap`,`MaSach`),
  ADD KEY `CT_PHIEUNHAPSACH_SACH_FK` (`MaSach`);

--
-- Chỉ mục cho bảng `ct_tacgia`
--
ALTER TABLE `ct_tacgia`
  ADD PRIMARY KEY (`MaSach`,`MaTacGia`),
  ADD KEY `CT_TACGIA_TACGIA_FK` (`MaTacGia`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`SoHoaDon`),
  ADD KEY `HOADON_KHACHHANG_FK` (`MaKhachHang`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKhachHang`);

--
-- Chỉ mục cho bảng `phieunhapsach`
--
ALTER TABLE `phieunhapsach`
  ADD PRIMARY KEY (`SoPhieuNhap`);

--
-- Chỉ mục cho bảng `phieuthutien`
--
ALTER TABLE `phieuthutien`
  ADD PRIMARY KEY (`SoPhieuThu`),
  ADD KEY `phieuthutien_KHACHHANG_FK` (`MaKhachHang`);

--
-- Chỉ mục cho bảng `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`),
  ADD KEY `SACH_THELOAISACH_FK` (`MaTheLoai`);

--
-- Chỉ mục cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`MaTacGia`);

--
-- Chỉ mục cho bảng `theloaisach`
--
ALTER TABLE `theloaisach`
  ADD PRIMARY KEY (`MaTheLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `SoHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `MaKhachHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `phieunhapsach`
--
ALTER TABLE `phieunhapsach`
  MODIFY `SoPhieuNhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `phieuthutien`
--
ALTER TABLE `phieuthutien`
  MODIFY `SoPhieuThu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `sach`
--
ALTER TABLE `sach`
  MODIFY `MaSach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `MaTacGia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `theloaisach`
--
ALTER TABLE `theloaisach`
  MODIFY `MaTheLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `baocaodoanhthu`
--
ALTER TABLE `baocaodoanhthu`
  ADD CONSTRAINT `BAOCAODOANHTHU_SACH_FK` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

--
-- Các ràng buộc cho bảng `baocaoton`
--
ALTER TABLE `baocaoton`
  ADD CONSTRAINT `BAOCAOTON_SACH_FK` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

--
-- Các ràng buộc cho bảng `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  ADD CONSTRAINT `CT_HOADON_HOADON_FK` FOREIGN KEY (`SoHoaDon`) REFERENCES `hoadon` (`SoHoaDon`),
  ADD CONSTRAINT `CT_HOADON_SACH_FK` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

--
-- Các ràng buộc cho bảng `ct_phieunhapsach`
--
ALTER TABLE `ct_phieunhapsach`
  ADD CONSTRAINT `CT_PHIEUNHAPSACH_PHIEUNHAPSACH_FK` FOREIGN KEY (`SoPhieuNhap`) REFERENCES `phieunhapsach` (`SoPhieuNhap`),
  ADD CONSTRAINT `CT_PHIEUNHAPSACH_SACH_FK` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`);

--
-- Các ràng buộc cho bảng `ct_tacgia`
--
ALTER TABLE `ct_tacgia`
  ADD CONSTRAINT `CT_TACGIA_SACH_FK` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`),
  ADD CONSTRAINT `CT_TACGIA_TACGIA_FK` FOREIGN KEY (`MaTacGia`) REFERENCES `tacgia` (`MaTacGia`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `HOADON_KHACHHANG_FK` FOREIGN KEY (`MaKhachHang`) REFERENCES `khachhang` (`MaKhachHang`);

--
-- Các ràng buộc cho bảng `phieuthutien`
--
ALTER TABLE `phieuthutien`
  ADD CONSTRAINT `phieuthutien_KHACHHANG_FK` FOREIGN KEY (`MaKhachHang`) REFERENCES `khachhang` (`MaKhachHang`);

--
-- Các ràng buộc cho bảng `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `SACH_THELOAISACH_FK` FOREIGN KEY (`MaTheLoai`) REFERENCES `theloaisach` (`MaTheLoai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
