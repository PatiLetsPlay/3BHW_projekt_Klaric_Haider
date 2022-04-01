create database Vokabeln_Abfragen;
use Vokabeln_Abfragen;

create table vokabelabfrage_admin(
	id int unsigned not null auto_increment,
    firstname varchar(50) not null, 
    lastaname varchar(50) not null, 
    usercode int unsigned not null,
    
    constraint id_PK primary key (id)
);

create table vokabelabfrage_guesser(
	id int unsigned not null auto_increment,
    firstname varchar(50) not null, 
    lastaname varchar(50) not null, 
	score int unsigned not null,
    
    constraint id_PK primary key (id)
);

select * from vokabelabfrage_guesser;
select * from vokabelabfrage_admin;