create database if not exists xuat_nhap_khau;
use xuat_nhap_khau;

create table phieu_xuat(
SoPX int auto_increment primary key,
ngayxuat date
);

create table vat_tu(
MaVTU int auto_increment primary key,
TenVTU varchar(50)
);

create table phieu_nhap(
SoPN int auto_increment primary key,
Ngaynhap date
);

create table donDH(
SoDH int auto_increment primary key,
NgayDH date,
MaNCC int,
foreign key(MaNCC) references nha_cung_cap(MaNCC) on delete set null
);

create table nha_cung_cap(
MaNCC int auto_increment primary key,
tenNCC varchar(50),
diachi varchar(50)
);

create table chi_tiet_phieu_xuat(
DGxuat double,
SLXuat int,
SoPX int,
MaVTU int,
primary key(SoPX, MaVTU),
foreign key(SoPX) references phieu_xuat(SoPX),
foreign key(MaVTU) references vat_tu(MaVTU)
);

create table chi_tiet_phieu_nhap(
DGNhap double,
SLNhap int,
MaVTU int,
SoPN int,
foreign key(MaVTU) references vat_tu(MaVTU),
foreign key(SoPN) references phieu_nhap(SoPN)
);

create table chi_tiet_dat_hang(
MaVTU int,
SoDH int,
foreign key(MaVTU) references vat_tu(MaVTU),
foreign key(SoDH) references donDH(SoDH)
);

create table sdt_ncc(
MaNCC int,
numberphone varchar(20),
primary key(MaNCC, numberphone),
foreign key (MaNCC) references nha_cung_cap(MaNCC)
);