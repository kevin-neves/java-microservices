create extension if not exists "uuid-ossp";

create table customer (
                          id serial PRIMARY KEY,
                          customer_name varchar(100) NOT NULL,
                          customer_code uuid not null default uuid_generate_v4(),
                          address varchar(100) NOT NULL,
                          cpf varchar(11) UNIQUE,
                          email varchar(100) NOT NULL
);
