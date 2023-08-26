create database if not exists qlbh;
use qlbh;

create table customer (
c_id int auto_increment primary key ,
c_name varchar(25),
c_age tinyint
);

create table `order` (
o_id int auto_increment primary key,
c_id int,
o_date datetime,
o_tatal_price int,
foreign key (c_id) references customer (c_id)
);

create table product (
p_id int auto_increment primary key,
p_name varchar(25),
p_price int
);
 
create table order_detail (
o_id int,
p_id int,
od_qty int,
primary key (p_id, o_id),
foreign key (o_id) references `order` (o_id),
foreign key (p_id) references product (p_id)
);

-- nhập giá trị cho các bảng
insert into customer 
value (1, 'Minh Quan', 10);
insert into customer 
value (2, 'Ngoc Oanh', 20);
insert into customer 
value (3, 'Hong Ha', 50);

insert into `order`
value (1,1, '2006-3-21',1);
insert into `order`
value (2,2,'2006-3-26',1);
insert into `order`
value (3,1,'2006-3-28',1);

insert into product
value (1,'May Giat', 3),
(2,'Tu Lanh', 5),
(3, 'Dieu Hoa', 7),
(4, 'Quat',1),
(5, 'Bep Dien', 2);

insert into order_detail (o_id, p_id, od_qty)
value (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- "1.Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order"
select o_id, o_date, o_tatal_price from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.c_id, c.c_name from customer c
where not exists (select * from `order` where c.c_id = c_id);
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select p.p_id, o.o_date , sum(order_detail.od_qty * o.o_tatal_price) as total
from `order` o join order_detail on o.o_id = order_detail.o_id
join product p on order_detail.p_id = p.o_id
group by p.p_id, o.o_date;
