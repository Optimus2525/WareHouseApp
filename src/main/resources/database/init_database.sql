create DATABASE warehouse;

create table customers(
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR (150),
                          address VARCHAR(255),
                          phone VARCHAR(30)
);

create table products (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(150),
                          quantity INT,
                          unit VARCHAR(10),
                          price DOUBLE
);

create table orders (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        customer_id INT NOT NULL,
                        product_id INT NOT NULL,
                        FOREIGN KEY(customer_id) REFERENCES customers(id),
                        FOREIGN KEY(product_id) REFERENCES products(id)
);

create table suppliers (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           name VARCHAR(100),
                           address VARCHAR(255),
                           phone VARCHAR(20)
);
