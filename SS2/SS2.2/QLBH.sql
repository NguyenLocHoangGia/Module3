create database if not exists QuanLyBanHang;
use QuanLyBanHang;

create table customer(
cID int auto_increment primary key,
cName varchar(50) not null,
cAge int check(cAge>0)
);

create table oder(
oID int auto_increment primary key,
oDate date,
oTotalPrice double,
cID int,
foreign key(cID) references customer(cID)
);

create table prduct(
pID int auto_increment primary key,
pName varchar(50) not null,
pPrice double
);

create table oderdetail(
oID int,
pID int,
odQTY varchar(50),
primary key(oID, pID),
foreign key(oID) references oder(oID),
foreign key(pID) references prduct(pID)
);