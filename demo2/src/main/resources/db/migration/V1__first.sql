create table users(
                      id bigserial primary key,
                      name varchar(100) not null,
                      age int not null);


-- create table product(
--                         id bigserial primary key,
--                         name varchar(200),
--                         date_created timestamp,
--                         date_updated timestamp,
--                         price float,
--                         weight float);

create table purchase(
                         id bigserial primary key,
                         name varchar(200),
                         iduser bigint references users(id),
                         date_created timestamp,
                         date_updated timestamp);

create table hotels(
                       id bigserial PRIMARY KEY,
                       name varchar(150) not null,
                       stars NUMERIC not null CHECK (stars > 0 and stars < 7),
                       country varchar(100) NOT null,
                       sity VARCHAR(100) NOT null);
--                        product_hotels bigint REFERENCES product(id)



create table apartaments(
                        id bigserial PRIMARY key,
                        rooms NUMERIC NOT NULL check (rooms > 0 and rooms < 10),
                        seasight bool not null,
                        is_reservated bool not null,
                        reservation_time NUMERIC not null);

create table hotels_apartaments(
                        id bigserial primary key,
                        id_hotels bigint REFERENCES hotels(id),
                        id_apartaments bigint references apartaments(id));

create table purchase_hotels(
                                id bigserial primary key,
                                idpur bigint references purchase(id),
                                idhot bigint references hotels(id)
);
