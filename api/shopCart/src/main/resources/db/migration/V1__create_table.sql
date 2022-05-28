create table shopCart.shopCart(
    id serial primary key,
    cpf_customer varchar(11) not null,
    total_price numeric(10,2) not null
);