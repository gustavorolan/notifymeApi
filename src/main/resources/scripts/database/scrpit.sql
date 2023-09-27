CREATE DATABASE notifyme;

CREATE TABLE if NOT EXISTS aplicativo (
    empresa_id
    BIGINT,
    id
    bigserial
    NOT
    NULL,
    api_key
    VARCHAR (
    255
), nome VARCHAR (
    255
), PRIMARY KEY (
    id
))

CREATE TABLE if NOT EXISTS bot_grupo_interesse (
    bot_plataforma_id
    BIGINT,
    grupo_interesse_id
    BIGINT,
    id
    bigserial
    NOT
    NULL,
    grupo_external_id
    VARCHAR (
    255
), nome VARCHAR (
    255
), PRIMARY KEY (
    id
))

CREATE TABLE if NOT EXISTS bot_plataforma (
    id
    bigserial
    NOT
    NULL,
    plataforma_id
    VARCHAR (
    255
), token VARCHAR (
    255
), PRIMARY KEY (
    id
))

CREATE TABLE if NOT EXISTS empresa (
    id
    bigserial
    NOT
    NULL,
    cnpj
    VARCHAR (
    255
), nome VARCHAR (
    255
), PRIMARY KEY (
    id
))

CREATE TABLE if NOT EXISTS evento (
    aplicativo_id
    BIGINT,
    data_abertura
    TIMESTAMP (
    6
), data_fechamento TIMESTAMP (
    6
), id bigserial NOT NULL, tipo_evento_id BIGINT, mensagem VARCHAR (
    255
), titulo VARCHAR (
    255
), stack_trace oid, PRIMARY KEY (
    id
))

CREATE TABLE if NOT EXISTS evento_plataforma (
    enviado
    boolean
    NOT
    NULL,
    evento_id
    BIGINT,
    id
    bigserial
    NOT
    NULL,
    mensagem_id_externo
    VARCHAR (
    255
), plataforma VARCHAR (
    255
), PRIMARY KEY (
    id
))

CREATE TABLE if NOT EXISTS grupo_interesse (
    aplicativo_id
    BIGINT,
    empresa_id
    BIGINT,
    id
    bigserial
    NOT
    NULL,
    nome
    VARCHAR (
    255
), PRIMARY KEY (
    id
))

CREATE TABLE if NOT EXISTS grupo_interesse_tipo_evento (
    grupo_interesse_id
    BIGINT,
    id
    bigserial
    NOT
    NULL,
    tipo_evento_id
    BIGINT,
    PRIMARY
    KEY (
    id
))

CREATE TABLE if NOT EXISTS tipo_evento (
    ativo
    boolean
    NOT
    NULL,
    empresa_id
    BIGINT,
    id
    bigserial
    NOT
    NULL,
    nome
    VARCHAR (
    255
), PRIMARY KEY (
    id
))

ALTER TABLE if EXISTS aplicativo
ADD CONSTRAINT FKflvt4ast2lfmiaykroqx6j616 FOREIGN KEY (empresa_id) REFERENCES empresa

ALTER TABLE if EXISTS bot_grupo_interesse
ADD CONSTRAINT FK514hb06wmjwqudxi43gi347mb FOREIGN KEY (bot_plataforma_id) REFERENCES bot_plataforma

ALTER TABLE if EXISTS bot_grupo_interesse
ADD CONSTRAINT FKmvaeyx7edeed999h8i4bxcvsx FOREIGN KEY (grupo_interesse_id) REFERENCES grupo_interesse

ALTER TABLE if EXISTS evento
ADD CONSTRAINT FK2y4vndfjbvg6wjdawj7pxkfcy FOREIGN KEY (aplicativo_id) REFERENCES aplicativo

ALTER TABLE if EXISTS evento
ADD CONSTRAINT FK6w38aahpdken3763tw3m3sbou FOREIGN KEY (tipo_evento_id) REFERENCES tipo_evento

ALTER TABLE if EXISTS evento_plataforma
ADD CONSTRAINT FKirhaten1m28yx6qqf3wa9ds21 FOREIGN KEY (evento_id) REFERENCES evento

ALTER TABLE if EXISTS grupo_interesse
ADD CONSTRAINT FK7xag46sqtssddo1uevtsjepvr FOREIGN KEY (aplicativo_id) REFERENCES aplicativo

ALTER TABLE if EXISTS grupo_interesse
ADD CONSTRAINT FKlqqv0px8qhslonwvxlysnregn FOREIGN KEY (empresa_id) REFERENCES empresa

ALTER TABLE if EXISTS grupo_interesse_tipo_evento
ADD CONSTRAINT FKip9ukk6k5h2qtc5nd6woidhhu FOREIGN KEY (grupo_interesse_id) REFERENCES grupo_interesse

ALTER TABLE if EXISTS grupo_interesse_tipo_evento
ADD CONSTRAINT FKdbqvc20vk7ijqsi6257owwjuf FOREIGN KEY (tipo_evento_id) REFERENCES tipo_evento

ALTER TABLE if EXISTS tipo_evento
ADD CONSTRAINT FKdo10xf28wsj21ops2h7kbw8x3 FOREIGN KEY (empresa_id) REFERENCES empresa


INSERT INTO empresa
VALUES (0, '12345678910', 'guzinhoBusiness');

INSERT INTO aplicativo
VALUES (0, 0, '12345678910', 'guzinhoapp');

INSERT INTO aplicativo
VALUES (0, 1, '12345678910', 'guzinhoapp2');