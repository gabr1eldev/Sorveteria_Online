create table usuario
(
nome varchar2(30) not null,
login varchar2(30) not null,
senha varchar2(30) not null,
constraint login primary key (login) enable
);

create table pedido 
(
id int not null,
cliente varchar2(50) not null,
dataPedido date not null,
constraint id primary key (id) enable
);

create table calda
(
nome varchar2(30) not null,
constraint pk_calda primary key (nome) enable
);

create table sabor
(
nome varchar2(30) not null,
constraint pk_sabor primary key (nome) enable
);

create table sorvete
(
id int not null,
quantidade int not null,
constraint pk_sorvete primary key (id) enable
);

alter table sorvete add pedido int not null;
alter table sorvete add foreign key (pedido) references pedido(id);
alter table sorvete add calda varchar2(30) not null;
alter table sorvete add foreign key (calda) references calda(nome);
alter table sorvete add sabor varchar2(30) not null;
alter table sorvete add foreign key (sabor) references sabor(nome);

create sequence S_PEDIDO minvalue 1 maxvalue 231231232 start with 1;
create sequence S_SORVETE minvalue 1 maxvalue 2312312312 start with 1;

insert into sabor(nome) values('MORANGO');
insert into sabor(nome) values('CHOCOLATE');
insert into sabor(nome) values('ABACAXI');
insert into sabor(nome) values('MANGA');
insert into sabor(nome) values('BAUNILHA');
insert into sabor(nome) values('LEITE CONDENSADO');
insert into sabor(nome) values('FLOCOS');
insert into sabor(nome) values('GOIABA');
insert into sabor(nome) values('BANANA');


insert into calda(nome) values('MORANGO');
insert into calda(nome) values('LEITE CONDENSADO');
insert into calda(nome) values('CHOCOLATE');
insert into calda(nome) values('UVA');
insert into calda(nome) values('CARAMELO');
insert into calda(nome) values('BAUNILHA');

select * from pedido;

