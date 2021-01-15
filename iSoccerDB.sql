create database iSoccerDB;
use iSoccerDB;

create table usuario(
    id_usuario int primary key auto_increment, 
    usuario varchar(15) not null unique, 
    senha varchar(15) not null
);

create table person(
    cpf varchar(11) primary key not null, 
    nome varchar(255) not null, 
    tel varchar(9) not null, 
    email varchar(255) not null,
    tipo varchar(255) not null,
    salary varchar(255) not null
);

create table doctor(
crm varchar(9) not null,
cpf varchar(11) not null unique, 
foreign key (cpf) references person(cpf)
);

create table driver(
enabling varchar(255) not null,
cpf varchar(11) not null unique, 
foreign key (cpf) references person(cpf)
);

create table fan(
typeFan int not null,
rateValue decimal (10, 2) not null, 
cpf varchar(11) not null unique,
foreign key (cpf) references person(cpf)
);

create table player(
playerFunction varchar(255) not null,
available boolean not null,
cpf varchar(11) not null unique, 
foreign key (cpf) references person(cpf)
);

create table bus(
	id_bus int primary key not null,
    available boolean not null,
    exist boolean not null
);

create table stadium(
id_stadium int primary key not null,
available boolean not null,
exist boolean not null,
 chairsNumber int not null,
 bathroomNumber int not null,
 snackBarNumber int not null
);
create table trainingCenter(
	id_trainingCenter int primary key not null,
	available boolean not null,
	exist boolean not null,
	bedroomNumber int not null
);

create table ingresso(
	id_ingresso int primary key not null,
	estoque int not null,
    precoVenda decimal (10, 2) not null,
    quantComprada int not null
);

create table compraIngresso(
	cpf varchar(11) primary key not null,
    valor decimal (10, 2) not null,
    quantComprada int not null
);

create table utilitario(
	id_utilitario int primary key not null,
	estoque int not null,
    precoVenda decimal (10, 2) not null,
    quantComprada int not null,
    nome varChar(256) not null
);

create table compraUtilitario(
	cpf varchar(11) primary key not null,
    valor decimal (10, 2) not null,
    quantComprada int not null
);

create table agendarVisita(
	cpf varchar(11) primary key not null,
    dia_visita date not null
);

select * from person;