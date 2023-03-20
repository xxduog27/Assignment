CREATE TABLE customer(
	customer_id INT PRIMARY KEY IDENTITY,
	customer_name NVARCHAR(255),
	email NVARCHAR(255),
	[password] NVARCHAR(255),
	[admin] INT
)

CREATE TABLE product(
	product_id INT PRIMARY KEY IDENTITY,
	product_name NVARCHAR(255),
	product_price MONEY,
	product_type NVARCHAR(255),
	product_img  VARBINARY(MAX),
	product_des NVARCHAR(255),
)