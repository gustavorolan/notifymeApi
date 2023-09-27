create database notifyme;

create table aplicativo (empresa_id bigint, id bigserial not null, api_key varchar(255), nome varchar(255), primary key (id));

create table empresa (id bigserial not null, cnpj varchar(11), nome varchar(255), primary key (id));

alter table if exists aplicativo add constraint FKflvt4ast2lfmiaykroqx6j616 foreign key (empresa_id) references empresa;


insert into empresa values (0, '12345678910', 'guzinhoBusiness');

insert into aplicativo values (0,0, '12345678910', 'guzinhoapp');

insert into aplicativo values (0,1, '12345678910', 'guzinhoapp2');


create table aplicativo (empresa_id bigint, id bigserial not null, api_key varchar(255), nome varchar(255), primary key (id))
    2023-09-27T09:52:32.829-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : create table bot_grupo_interesse (bot_plataforma_id bigint, grupo_interesse_id bigint, id bigserial not null, grupo_external_id varchar(255), nome varchar(255), primary key (id))
2023-09-27T09:52:32.836-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : create table bot_plataforma (id bigserial not null, plataforma_id varchar(255), token varchar(255), primary key (id))
2023-09-27T09:52:32.842-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : create table empresa (id bigserial not null, cnpj varchar(255), nome varchar(255), primary key (id))
2023-09-27T09:52:32.849-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : create table evento (aplicativo_id bigint, data_abertura timestamp(6), data_fechamento timestamp(6), id bigserial not null, tipo_evento_id bigint, mensagem varchar(255), titulo varchar(255), stack_trace oid, primary key (id))
2023-09-27T09:52:32.856-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : create table evento_plataforma (enviado boolean not null, evento_id bigint, id bigserial not null, mensagem_id_externo varchar(255), plataforma varchar(255), primary key (id))
2023-09-27T09:52:32.863-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : create table grupo_interesse (aplicativo_id bigint, empresa_id bigint, id bigserial not null, nome varchar(255), primary key (id))
2023-09-27T09:52:32.868-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : create table grupo_interesse_tipo_evento (grupo_interesse_id bigint, id bigserial not null, tipo_evento_id bigint, primary key (id))
2023-09-27T09:52:32.873-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : create table tipo_evento (ativo boolean not null, empresa_id bigint, id bigserial not null, nome varchar(255), primary key (id))
2023-09-27T09:52:32.879-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists aplicativo add constraint FKflvt4ast2lfmiaykroqx6j616 foreign key (empresa_id) references empresa
2023-09-27T09:52:32.885-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists bot_grupo_interesse add constraint FK514hb06wmjwqudxi43gi347mb foreign key (bot_plataforma_id) references bot_plataforma
2023-09-27T09:52:32.889-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists bot_grupo_interesse add constraint FKmvaeyx7edeed999h8i4bxcvsx foreign key (grupo_interesse_id) references grupo_interesse
2023-09-27T09:52:32.892-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists evento add constraint FK2y4vndfjbvg6wjdawj7pxkfcy foreign key (aplicativo_id) references aplicativo
2023-09-27T09:52:32.895-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists evento add constraint FK6w38aahpdken3763tw3m3sbou foreign key (tipo_evento_id) references tipo_evento
2023-09-27T09:52:32.899-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists evento_plataforma add constraint FKirhaten1m28yx6qqf3wa9ds21 foreign key (evento_id) references evento
2023-09-27T09:52:32.901-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists grupo_interesse add constraint FK7xag46sqtssddo1uevtsjepvr foreign key (aplicativo_id) references aplicativo
2023-09-27T09:52:32.904-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists grupo_interesse add constraint FKlqqv0px8qhslonwvxlysnregn foreign key (empresa_id) references empresa
2023-09-27T09:52:32.907-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists grupo_interesse_tipo_evento add constraint FKip9ukk6k5h2qtc5nd6woidhhu foreign key (grupo_interesse_id) references grupo_interesse
2023-09-27T09:52:32.910-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists grupo_interesse_tipo_evento add constraint FKdbqvc20vk7ijqsi6257owwjuf foreign key (tipo_evento_id) references tipo_evento
2023-09-27T09:52:32.913-03:00 DEBUG 2256 --- [           main] org.hibernate.SQL                        : alter table if exists tipo_evento add constraint FKdo10xf28wsj21ops2h7kbw8x3 foreign key (empresa_id) references empresa