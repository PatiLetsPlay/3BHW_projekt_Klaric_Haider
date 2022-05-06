create database Vokabeln_Abfragen collate utf8mb4_general_ci;
use Vokabeln_Abfragen;

create table vokabelabfrage_admin(
	id int unsigned not null auto_increment,
    firstname varchar(50) not null, 
    lastname varchar(50) not null, 
    usercode int unique not null,
    
    constraint id_PK primary key (id)
);

create table vokabelabfrage_guesser(
	id int unsigned not null auto_increment,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
	score int unsigned not null,
    
    constraint id_PK primary key (id)
);
drop table if exists vokabelabfrage_admin;
drop table if exists vokabelabfrage_guesser;

select * from vokabelabfrage_guesser;
select * from vokabelabfrage_guesser where firstname = "Patrick" and lastname = "Klaric";
select * from vokabelabfrage_admin;