CREATE DATABASE CNPM2020
USE CNPM2020

CREATE TABLE SACH
(
	MaSach char(4) Primary key,
	TenSach varchar(50),
	TacGia varchar(50),
	TheLoai varchar(20),
	SoLuong int,
	DonGiaNhap int,
	DonGiaBan int
)

CREATE TABLE KHACHHANG
(
	MaKH char(4) Primary key,
	TenKH varchar(50),
	SDT varchar(14),
	Email varchar(40),
	DiaChi varchar(50),
	TienNo int
)

CREATE TABLE PHIEUNHAP
(
	MaPN char(4) Primary key,
	NgayPN smalldatetime,
	TongTien int
)

CREATE TABLE CTPN
(
	MaPN char(4),
	MaSach char(4),
	SoLuong int,
	CONSTRAINT PK_CTPN Primary key(MaPN, MaSach)
)

CREATE TABLE HOADON
(
	MaHD char(4) Primary key,
	NgayHD smalldatetime,
	TongTien int,
	ConLai int
)

CREATE TABLE CTHD
(
	MaHD char(4),
	MaSach char(4),
	SoLuong int,
	CONSTRAINT PK_CTHD Primary key(MaHD, MaSach)
)

CREATE TABLE THUTIEN
(
	MaTT char(4) Primary key,
	MaHD char(4),
	MaKH char(4),
	NgayTT smalldatetime,
	TienThu int
)

CREATE TABLE BAOCAOTON
(
	MaSach char(4),
	Thang int,
	Nam int,
	TonDau int,
	PhatSinh int,
	TonCuoi int,
	CONSTRAINT PK_BCT Primary key(MaSach, Thang, Nam)
)

CREATE TABLE BAOCAODOANHTHU
(
	MaKH char(4),
	Thang int,
	Nam int,
	NoDau int,
	PhatSinh int,
	NoCuoi int,
	CONSTRAINT PK_BCDT Primary key(MaKH, Thang, Nam)
)

CREATE TABLE THAMSO
(
	SoLuongNhapToiThieu int,
	SoLuongTonToiThieu int,
	TiLeLai float
)

ALTER TABLE CTPN
	ADD CONSTRAINT FK_CTPN_PN
	FOREIGN KEY (MaPN)
	REFERENCES PHIEUNHAP(MaPN)

ALTER TABLE CTPN
	ADD CONSTRAINT FK_CTPN_SACH
	FOREIGN KEY (MaSach)
	REFERENCES SACH(MaSach)

ALTER TABLE CTHD
	ADD CONSTRAINT FK_CTHD_SACH
	FOREIGN KEY (MaSach)
	REFERENCES SACH(MaSach)

ALTER TABLE CTHD
	ADD CONSTRAINT FK_CTHD_HD
	FOREIGN KEY (MaHD)
	REFERENCES HOADON(MaHD)

ALTER TABLE THUTIEN
	ADD CONSTRAINT FK_TT_HD
	FOREIGN KEY (MaHD)
	REFERENCES HOADON(MaHD)

ALTER TABLE THUTIEN
	ADD CONSTRAINT FK_TT_KH
	FOREIGN KEY (MaKH)
	REFERENCES KHACHHANG(MaKH)

ALTER TABLE BAOCAOTON
	ADD CONSTRAINT FK_BCT_SACH
	FOREIGN KEY (MaSach)
	REFERENCES SACH(MaSACH)

ALTER TABLE BAOCAODOANHTHU
	ADD CONSTRAINT FK_BCDT_KH
	FOREIGN KEY (MaKH)
	REFERENCES KHACHHANG(MaKH)