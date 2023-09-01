CREATE DATABASE demo;
USE demo;

CREATE TABLE Products (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    productCode VARCHAR(50) NOT NULL,
    productName VARCHAR(255) NOT NULL,
    productPrice DECIMAL(10, 2) NOT NULL,
    productAmount INT NOT NULL,
    productDescription TEXT,
    productStatus VARCHAR(20)
);

INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
VALUES
    ('P001', 'Product 1', 100.00, 50, 'Description 1', 'Available'),
    ('P002', 'Product 2', 150.00, 30, 'Description 2', 'Out of stock');

-- Unique Index trên cột productCode
CREATE UNIQUE INDEX idx_productCode ON Products (productCode);

-- Composite Index trên cột productName và productPrice
CREATE INDEX idx_productNamePrice ON Products (productName, productPrice);

-- Ví dụ với câu truy vấn
EXPLAIN SELECT * FROM Products WHERE productCode = 'P001';

-- Tạo view
CREATE VIEW ProductInfo AS
SELECT productCode, productName, productPrice, productStatus FROM Products;

-- Sửa đổi view
ALTER VIEW ProductInfo AS
SELECT productCode, productName, productPrice FROM Products;

-- Xoá view
DROP VIEW IF EXISTS ProductInfo;

-- Tạo stored procedure lấy tất cả thông tin sản phẩm
DELIMITER //
CREATE PROCEDURE GetAllProducts()
BEGIN
    SELECT * FROM Products;
END //
DELIMITER ;

-- Tạo stored procedure thêm sản phẩm mới
DELIMITER //
CREATE PROCEDURE AddProduct(
    IN p_productCode VARCHAR(50),
    IN p_productName VARCHAR(255),
    IN p_productPrice DECIMAL(10, 2),
    IN p_productAmount INT,
    IN p_productDescription TEXT,
    IN p_productStatus VARCHAR(20)
)
BEGIN
    INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
    VALUES (p_productCode, p_productName, p_productPrice, p_productAmount, p_productDescription, p_productStatus);
END //
DELIMITER ;

-- Tạo stored procedure sửa thông tin sản phẩm theo Id
DELIMITER //
CREATE PROCEDURE UpdateProduct(
    IN p_Id INT,
    IN p_productName VARCHAR(255),
    IN p_productPrice DECIMAL(10, 2),
    IN p_productAmount INT,
    IN p_productDescription TEXT,
    IN p_productStatus VARCHAR(20)
)
BEGIN
    UPDATE Products
    SET productName = p_productName,
        productPrice = p_productPrice,
        productAmount = p_productAmount,
        productDescription = p_productDescription,
        productStatus = p_productStatus
    WHERE Id = p_Id;
END //
DELIMITER ;

-- Tạo stored procedure xoá sản phẩm theo Id
DELIMITER //
CREATE PROCEDURE DeleteProduct(
    IN p_Id INT
)
BEGIN
    DELETE FROM Products WHERE Id = p_Id;
END //
DELIMITER ;
