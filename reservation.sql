drop database if exists reserve;
create database reserve;
use reserve;

drop table if exists reservation_details;
drop table if exists books;
drop table if exists reservations;

create table books (
    id int not null auto_increment,
    title varchar(255) not null,
    quantity int default 1, 

    constraint pk_id primary key (id)
);

create table reservations (
    id int not null auto_increment,
    name varchar(255) not null,
    reservation_date date,

    constraint pk_id primary key (id)
);

create table reservation_details (
    id int not null auto_increment,
    book_id int,
    reservation_id int,

    constraint pk_id primary key (id),
    constraint fk_book_id foreign key (book_id) references books(id),
    constraint fk_reservation_id foreign key (reservation_id) references reservations(id)
);

grant all privileges on reserve.* to 'chloe'@'%';
flush privileges;