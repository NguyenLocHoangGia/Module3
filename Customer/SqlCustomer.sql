create database if not exists Customer;
use Customer;

create table Customer_type(
customer_type_id  INT PRIMARY KEY AUTO_INCREMENT,
customer_type_name varchar(45)
);

create table Customer (
customer_id  INT PRIMARY KEY AUTO_INCREMENT,
customer_name varchar(50),
customer_birthday date,
customer_gender bit(1),
customer_id_card varchar(45),
customer_phone varchar(10),
customer_email varchar(45),
customer_address varchar(45),
customer_type_id int,
foreign key (customer_type_id) references Customer_type (customer_type_id)
);

-- Thêm giá trị vào bảng Customer_type
INSERT INTO Customer_type (customer_type_name) VALUES
('Regular'),
('Premium'),
('VIP');

-- Thêm giá trị vào bảng Customer
INSERT INTO Customer (
    customer_name, 
    customer_birthday, 
    customer_gender, 
    customer_id_card, 
    customer_phone, 
    customer_email, 
    customer_address, 
    customer_type_id
) VALUES
('John Doe', '1990-01-15', 1, '123456789', '1234567890', 'john.doe@email.com', '123 Main St', 1),
('Jane Doe', '1985-05-20', 0, '987654321', '9876543210', 'jane.doe@email.com', '456 Oak St', 2),
('Bob Smith', '1995-08-10', 1, '456789123', '4567891230', 'bob.smith@email.com', '789 Pine St', 3);
select * from customer_type where customer_type_id = 1;
SELECT 
    c.*,
    ct.customer_type_name
FROM 
    customer c
JOIN 
    customer_type ct ON c.customer_type_id = ct.customer_type_id;
