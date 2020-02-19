-- Esta base de datos corresponde al laboratorio1 del curso de plataformas moviles.

create database universidad;
use universidad;

create table curso( varchar(15) codigo NOT NULL,  nombre varchar(30) NOT NULL, INT creditos, INT horas , constraint PK_STATE primary key (codigo)
);
