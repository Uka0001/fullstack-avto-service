create database autoservice_db;
create table public.cars
(
    id     bigserial
        primary key,
    brand  varchar(255),
    model  varchar(255),
    number varchar(255),
    year   integer not null
);

alter table public.cars
    owner to postgres;

create table public.goods
(
    id        bigserial
        primary key,
    good_cost numeric(38, 2),
    name      varchar(255),
    order_id  bigint
        constraint fkhh1q63rgg42pbe1tnmn1q8q0j
            references public.orders
);

alter table public.goods
    owner to postgres;

create table public.masters
(
    id        bigserial
        primary key,
    full_name varchar(255)
);

alter table public.masters
    owner to postgres;

create table public.orders
(
    id               bigserial
        primary key,
    date_of_adoption date,
    description      varchar(255),
    status           smallint,
    total_cost       numeric(38, 2),
    car_id           bigint
        constraint fkd2p23ixwrrt395glgi9nnbj23
            references public.cars,
    master_id        bigint
        constraint fkq2791o2cbhbwdhpbertk5v6hj
            references public.masters
);

alter table public.orders
    owner to postgres;

create table public.owners
(
    id         bigserial
        primary key,
    owner_name varchar(255)
);

alter table public.owners
    owner to postgres;

create table public.services
(
    id        bigserial
        primary key,
    name      varchar(255),
    price     numeric(38, 2),
    status    smallint,
    master_id bigint
        constraint fk565hd47u11qajksyfi4gqrfu0
            references public.masters,
    order_id  bigint
        constraint fknmykpsxcf4bgaecn9g3vdbc1s
            references public.orders
);

alter table public.services
    owner to postgres;

