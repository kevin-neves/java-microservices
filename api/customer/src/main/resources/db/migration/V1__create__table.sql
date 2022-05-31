create table customer (
    id serial PRIMARY KEY,
    customer_name varchar(100) NOT NULL,
    customer_code uuid,
    address varchar(100) NOT NULL,
    cpf varchar(11) UNIQUE,
    email varchar(100) NOT NULL
);
