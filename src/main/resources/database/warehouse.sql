drop database if exists warehouse_main;
create database warehouse_main;
use warehouse_main;

create table customers (
                           id INT AUTO_INCREMENT NOT NULL,
                           name VARCHAR (150),
                           address VARCHAR(200),
                           phone VARCHAR(30),
                           PRIMARY KEY (id)
);

CREATE TABLE units (
						id INT AUTO_INCREMENT NOT NULL,
                        unitName VARCHAR (20),
                        PRIMARY KEY (id)
);

create table suppliers (
                           id INT AUTO_INCREMENT NOT NULL,
                           name VARCHAR (150),
                           address VARCHAR(200),
                           phone VARCHAR(30),
                           PRIMARY KEY (id)
);

create table products (
                          id INT AUTO_INCREMENT NOT NULL,
                          name VARCHAR(150),
                          unit_id INT,
                          supplier_id INT,
                          unitPrice DOUBLE,
                          unitsInStock INT,
                          PRIMARY KEY (id),
                          CONSTRAINT FK_ProductUnit 
                          FOREIGN KEY (unit_id) REFERENCES units(id),
                          CONSTRAINT FK_ProductSupplier 
                          FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);

create table orders (
                          id INT AUTO_INCREMENT NOT NULL,
                          customer_id INT NOT NULL,
                          orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          totalSum DOUBLE NOT NULL,
                          isPaid BOOL DEFAULT 0,
                          PRIMARY KEY (id),
                          CONSTRAINT FK_OrdersCustomer 
                          FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE carts (
						id INT AUTO_INCREMENT NOT NULL,
                        order_id INT NOT NULL,
                        product_id INT NOT NULL,
                        quantity INT NOT NULL,
                        PRIMARY KEY (id),
                        CONSTRAINT FK_CartOrder 
                        FOREIGN KEY (order_id) REFERENCES orders(id),
                        CONSTRAINT FK_CartProduct 
                        FOREIGN KEY (product_id) REFERENCES products(id)
);