create database Vokabeln_Abfragen;
use Vokabeln_Abfragen;

create table vokabelabfrage_admin(
	id int unsigned not null auto_increment,
    firstname varchar(50) not null, 
    lastaname varchar(50) not null, 
    usercode int unique not null,
    
    constraint id_PK primary key (id)
);

create table vokabelabfrage_guesser(
	id int unsigned not null auto_increment,
    firstname varchar(50) not null, 
    lastaname varchar(50) not null, 
    guesser_password varchar(100) not null,
	score int unsigned not null,
    
    constraint id_PK primary key (id)
);
#drop table vokabelabfrage_admin;
#drop table vokabelabfrage_guesser;
select * from vokabelabfrage_guesser;
select * from vokabelabfrage_admin;