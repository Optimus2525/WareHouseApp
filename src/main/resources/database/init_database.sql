drop database if exists warehouse;
create database warehouse;
use warehouse;

create table customers (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR (150),
                           address VARCHAR(255),
                           phone VARCHAR(30)
);

create table suppliers (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(100),
                           address VARCHAR(255),
                           phone VARCHAR(20)
);

create table products (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(150),
                          quantity INT,
                          unit VARCHAR(10),
                          price DOUBLE,
                          suppliers_id BIGINT NOT NULL,
                          FOREIGN  KEY (suppliers_id) REFERENCES suppliers(id)
);

create table orders (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        customer_id BIGINT NOT NULL,
                        product_id BIGINT NOT NULL,
                        FOREIGN KEY(customer_id) REFERENCES customers(id),
                        FOREIGN KEY(product_id) REFERENCES products(id)
);