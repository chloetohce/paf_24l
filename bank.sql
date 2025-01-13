drop database if exists bank;
create database bank;
use bank;
drop table if exists accounts;

create table accounts(
    id int not null auto_increment,
    name varchar(150) not null,
    isActive boolean,
    balance float default '100.0',

    constraint pk_id primary key(id)
);

insert into accounts(name, isActive, balance)
    values('Test', true, 300.0);

update accounts set isActive = false where id=1;

grant all privileges on bank.* to 'chloe'@'%';
flush privileges;