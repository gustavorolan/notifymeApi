create database notifyme;

create table aplicativo (empresa_id bigint, id bigserial not null, api_key varchar(255), nome varchar(255), primary key (id));

create table empresa (id bigserial not null, cnpj varchar(11), nome varchar(255), primary key (id));

alter table if exists aplicativo add constraint FKflvt4ast2lfmiaykroqx6j616 foreign key (empresa_id) references empresa;


insert into empresa values (0, '12345678910', 'guzinhoBusiness');

insert into aplicativo values (0,0, '12345678910', 'guzinhoapp');

insert into aplicativo values (0,1, '12345678910', 'guzinhoapp2');