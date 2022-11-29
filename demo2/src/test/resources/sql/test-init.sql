drop table if exists users cascade;
drop table if exists purchase cascade;
drop table if exists product cascade;
drop table if exists purchase_product cascade;

create table users
(
    id identity primary key,
    name varchar(100) not null,
    age  int          not null
);


create table purchase
(
    id identity primary key,
    name         varchar(200),
    iduser       bigint references users (id),
    date_created timestamp,
    date_updated timestamp
);

create table product
(
    id identity primary key,
    name         varchar(200),
    date_created timestamp,
    date_updated timestamp,
    price        float,
    weight       float
);

create table purchase_product
(
    id identity primary key,
    idpur long references purchase (id),
    idpro long references product (id)
);


INSERT INTO product
(id, name, date_created, date_updated, price, weight)
VALUES (1, 'chcocolate ', NULL, NULL, 120.0, 1.0);
INSERT INTO product
(id, name, date_created, date_updated, price, weight)
VALUES (2, 'mango', NULL, NULL, 122.0, 1.0);
INSERT INTO product
(id, name, date_created, date_updated, price, weight)
VALUES (3, 'icecream', NULL, NULL, 20.0, 1.0);


INSERT INTO users
(id, name, age)
VALUES (3, 'user 23', 1);
INSERT INTO users
(id, name, age)
VALUES (5, 'user 2', 10);
INSERT INTO users
(id, name, age)
VALUES (4, 'user1', 21);
INSERT INTO users
(id, name, age)
VALUES (7, 'user2', 21);

INSERT INTO purchase
(id, name, iduser, date_created, date_updated)
VALUES (1, 'Purchase', 3, NULL, NULL);
INSERT INTO purchase
(id, name, iduser, date_created, date_updated)
VALUES (2, 'P1', 3, NULL, NULL);
INSERT INTO purchase
(id, name, iduser, date_created, date_updated)
VALUES (3, 'P2', 5, NULL, NULL);
INSERT INTO purchase
(id, name, iduser, date_created, date_updated)
VALUES (4, 'P3', 5, NULL, NULL);
INSERT INTO purchase
(id, name, iduser, date_created, date_updated)
VALUES (5, 'P4', 3, NULL, NULL);


INSERT INTO purchase_product
(id, idpur, idpro)
VALUES (1, 2, 1);
INSERT INTO purchase_product
(id, idpur, idpro)
VALUES (2, 2, 2);
INSERT INTO purchase_product
(id, idpur, idpro)
VALUES (3, 4, 3);
INSERT INTO purchase_product
(id, idpur, idpro)
VALUES (4, 5, 2);
INSERT INTO purchase_product
(id, idpur, idpro)
VALUES (5, 3, 1);