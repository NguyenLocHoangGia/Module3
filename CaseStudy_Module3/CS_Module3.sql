create database case_study;
use case_study; 

create table vi_tri(
ma_vi_tri int auto_increment primary key,
ten_vi_tri varchar(45)
);

create table trinh_do(
ma_trinh_do int auto_increment key,
ten_trinh_do varchar(45)
);

create table bo_phan(
ma_bo_phan int auto_increment primary key,
ten_bo_phan varchar(45)
);

create table nhan_vien(
ma_nhan_vien int primary key,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
luong double,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key (ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key (ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key (ma_bo_phan) references bo_phan(ma_bo_phan)
);

create table loai_khach(
ma_loai_khach int primary key,
ten_loai_khach varchar(45)
);

create table khach_hang(
ma_khach_hang int auto_increment primary key,
ma_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (ma_loai_khach) references loai_khach(ma_loai_khach)
);

create table hop_dong(
ma_hop_dong int auto_increment primary key,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
foreign key (ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key (ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key (ma_dich_vu) references dich_vu(ma_dich_vu)
);

create table loai_dich_vu(
ma_loai_dich_vu int auto_increment primary key,
ten_loai_dich_vu varchar(45)
);

create table dich_vu(
ma_dich_vu int auto_increment primary key,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
ma_kieu_thue int,
ma_loai_dich_vu int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
dich_vu_mien_phi_di_kem text,
foreign key (ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu),
foreign key (ma_kieu_thue) references kieu_thue(ma_kieu_thue)
);

create table kieu_thue(
ma_kieu_thue int auto_increment primary key,
ten_kieu_thue varchar(45)
);

create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int auto_increment primary key,
ma_hop_dong int,
ma_dich_vu_di_kem int,
so_luong int,
foreign key (ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key (ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);

create table dich_vu_di_kem(
ma_dich_vu_di_kem int auto_increment primary key,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(10),
trang_thai varchar(45)
);

-- thêm dữ liệu cho các bảng
insert into vi_tri(ma_vi_tri,ten_vi_tri) 
values (1,'Giám đốc'),
(2,'Quản lí'),
(3,'Nhân viên'),
(4, 'Mekting');

insert into trinh_do (ma_trinh_do,ten_trinh_do)
value (1, 'Trung cấp'),
(2, 'Cao đẳng'),
(3, 'Đại Học'),
(4, 'Tốt nghiệp c3');

insert into bo_phan(ma_bo_phan,ten_bo_phan)
 values (1,'Hành chính'),
 (2,'Phục vụ'),
 (3,'Quản lý');


INSERT INTO nhan_vien (ma_nhan_vien, ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan) 
VALUES 
(1, 'Nguyen Van Hai', '1999-12-12', '123456789', 10000000, '0987654321', 'NVA@gmail.com', 'Đà Nẵng', 1, 1, 1), 
(2, 'Nguyễn Thị Tien', '1998-12-12', '1234567809', 9000000, '0987654312', 'NTB@gmail.com', 'Quảng Trị', 1, 1, 2), 
(3, 'Nguyễn Văn Kien', '2000-12-12', '1234509876', 9765432,'0923812348', 'NVC@gmail.com', 'Quảng Nam', 1, 1, 3), 
(4, 'Nguyễn Thị Dung', '1990-12-12', '1234567098', 1123456,'082345982', 'NTD@gmail.com', 'HCM', 1, 1, 1), 
(5, 'Nguyen Van En', '1998-12-12', '1357924680', 99887762,'023458257' ,'NVE@gmail.com', 'Hà Nội', 3, 1, 1);

Insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) 
values('Nguyen Van Ab', '1999-12-11', 1, '8934572323','0923467212','NVAb@gmail.com', 'Hải Phòng', 2),
('Nguyen Thi Ba','1998-2-12',0,'2384728412','0234682171','NTBa@gamil.com', 'Đà Nẵng',1),
('Nguyễn Văn Ca', '1997-4-3',1,'8234458745','0374631231','NVCa@gmail.com', 'Quảng Trị', 3);

insert into loai_khach(ma_loai_khach,ten_loai_khach)
 values (1,'Diamond'),
 (2,'Platinium'),
 (3,'Gold'),
 (4,'Silver'),
 (5,'Member');
 
 Insert into kieu_thue(ten_kieu_thue) 
 values('năm'),
 ('tháng'),
 ('ngày'),
 ('giờ');
 
 Insert into loai_dich_vu(ten_loai_dich_vu) 
 values('Villa'),
 ('House'),
 ('Room');

Insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,ma_loai_dich_vu) 
values('Villa s1',10000,10000,10,'VIP','Sân vườn rộng',null,4,2,1),
('House s1',5000,5000,8,'VIP','Có hồ bơi',100,3,2,2),
('Room s1',3000,3000,5,'VIP', 'Có giường lớn',null,3,3,3),
('House s2',3000,3000,5,'Thường', 'Có bãi đỗ xe trung bình',null,2,2,2);

Insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai) 
values ('Đánh goft',5000,'giờ','tốt'),
('Thuê xe',1000,'giờ','tốt'),
('Thuê lều camping',500,'ngày', 'thiếu 2 chiếc'),
('Ăn uống',1000, 'suất', 'tốt');

Insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu) 
values('2020-07-14','2020-07-21',200000,7,3,1),
('2021-06-01','2021-06-03',0,7,7,6),
('2021-06-17','2021-06-18',150000,3,4,1),
('2021-05-25','2021-05-27',0,7,10,1);

Insert into hop_dong_chi_tiet(so_luong,ma_hop_dong,ma_dich_vu_di_kem) 
 values(5,2,4),(8,2,5),(15,2,6),(1,3,1),(11,3,1),(1,1,3),(2,1,2),(2,12,2);

--  2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
 select * from nhan_vien where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and length(ho_ten) <= 15;
-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
  select * from khach_hang where (year(now()) - year(ngay_sinh) between 18 and 50) and (dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị');
-- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select K.ma_khach_hang, K.ho_ten, Lk.ten_loai_khach,count(1) as so_lan_dat from hop_dong H
 join khach_hang K on H.ma_khach_hang = K.ma_khach_hang
 join loai_khach LK on Lk.ma_loai_khach = K.ma_loai_khach
 where Lk.ten_loai_khach = 'Diamond'
 group by K.ma_khach_hang, K.ho_ten, Lk.ten_loai_khach
 order by so_lan_dat ;

-- '5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
 -- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
 -- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra). '
 select K.ma_khach_hang,K.ho_ten,L.ten_loai_khach,H.ma_hop_dong,DV.ten_dich_vu,H.ngay_lam_hop_dong,H.ngay_ket_thuc, (H.tien_dat_coc + HDCT.so_luong * DVDK.gia ) as tong_tien from khach_hang K
 left join hop_dong H on  K.ma_khach_hang = H.ma_khach_hang
 left join loai_khach L on L.ma_loai_khach = K.ma_loai_khach
 left join dich_vu DV on DV.ma_dich_vu = H.ma_dich_vu
 left join hop_dong_chi_tiet HDCT on HDCT.ma_hop_dong = H.ma_hop_dong
 left join dich_vu_di_kem DVDK on DVDK.ma_dich_vu_di_kem = HDCT.ma_dich_vu_di_kem;