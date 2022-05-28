create extension if not exists "uuid-ossp";

create table product (
    id serial primary key,
    product_name varchar(100) not null,
    product_code uuid not null default uuid_generate_v4(),
    product_description text,
    store_price numeric(10,2) not null,
    in_stock boolean not null,
    product_size varchar(100) not null,
    product_color varchar(100) not null,
    product_brand varchar(100) not null,
    product_quantity integer not null
);