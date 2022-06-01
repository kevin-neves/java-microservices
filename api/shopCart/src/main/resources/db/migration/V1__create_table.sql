create table shop_cart(
    id serial not null primary key,
    cpf_customer varchar(11) not null,
    total_price numeric(10,2),
    status varchar(10) not null
);

create table product(
    id serial not null primary key,
    product_id_reference numeric not null,
    product_name varchar(100) not null,
    product_price numeric(10,2) not null,
    product_quantity int not null,
    shop_cart_id int references shop_cart(id)
);