CREATE TABLE address (
    id number(20) PRIMARY KEY,
    address1 varchar2(255),
    address2 varchar2(255),
    city varchar2(20),
    postal_code varchar2(10),
    country varchar2(20)
);

CREATE TABLE user_details
(
    id number(20) PRIMARY KEY,
    user_email varchar2(60),
    user_password varchar2(60),
    user_role varchar2(20),
    contact_first_name varchar2(60),
    contact_last_name varchar2(60),
    address_id number(20),
    contact_phone number(20)
);

CREATE TABLE product_model
(
    id number(20) PRIMARY KEY,
    name varchar2(20) NOT NULL,
    description varchar2(50) NOT NULL,
    features varchar2(100) NOT NULL,
    price number(10,2) NOT NULL,
    threshold number(3) NOT NULL
);

CREATE TABLE inventory
(
    product_model_id number(20),
    quantity number(5) NOT NULL,
    FOREIGN KEY(product_model_id) REFERENCES product_model(id)
);

CREATE TABLE order_details
(
    id number(20) PRIMARY KEY,
    user_id number(20),
    user_type varchar2(20),
    order_date date NOT NULL,
    amount number(12,2) NOT NULL,
    FOREIGN KEY(user_id) REFERENCES user_details(id)
);

CREATE TABLE product
(
    id number(20) PRIMARY KEY,
    product_model_id number(20),
    product_model_name varchar2(20),
    status varchar2(20) NOT NULL,
    order_id number(20),
    FOREIGN KEY(product_model_id) REFERENCES product_model(id),
    FOREIGN KEY(order_id) REFERENCES order_details(id)
);

CREATE TABLE order_product
(
    order_id number(20),
    product_model_id number(20),
    quantity number(5) NOT NULL,
    FOREIGN KEY(order_id) REFERENCES product_model(id),
    FOREIGN KEY(product_model_id) REFERENCES order_details(id)
);