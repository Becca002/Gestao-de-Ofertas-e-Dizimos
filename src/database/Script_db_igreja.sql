create database igreja;
create schema if not exists igreja ;

use igreja ;

-- -----------------------------------------------------
-- table igreja.usuario
-- -----------------------------------------------------

create table if not exists igreja.usuario (

  usuario_id int not null auto_increment,

  login varchar(100) not null,

  senha varchar(20) not null,

  primary key (usuario_id))

engine = innodb;

-- -----------------------------------------------------
-- table igreja.log_autenticacao
-- -----------------------------------------------------

create table if not exists igreja.log_autenticacao (

  log_autenticacao_id int not null auto_increment,

  login varchar(100) not null,

  senha varchar(20) not null,

  data_acesso timestamp not null default current_timestamp,

  usuario_id int null,

  primary key (log_autenticacao_id),

  index fk_log_autenticacao_usuario_idx (usuario_id asc) visible,

  constraint fk_log_autenticacao_usuario

    foreign key (usuario_id)

    references igreja.usuario (usuario_id)

    on delete no action

    on update no action)

engine = innodb;

-- -----------------------------------------------------
-- table igreja.membro
-- -----------------------------------------------------

create table if not exists igreja.membro (

  membro_id int not null auto_increment,

  nome varchar(100) not null,

  data_cadastro date not null,

  telefone char(11) null,

  data_nascimento date null,

  usuario_id int not null,

  primary key (membro_id),

  index fk_membro_usuario1_idx (usuario_id asc) visible,

  constraint fk_membro_usuario1

    foreign key (usuario_id)

    references igreja.usuario (usuario_id)

    on delete no action

    on update no action)

engine = innodb;

- ------------------------------------------------------
-- table igreja.oferta
-- -----------------------------------------------------

create table if not exists igreja.oferta (

  oferta_id int not null auto_increment,

  valor decimal(10,2) not null,

  data_hora timestamp null default null,

  pago tinyint not null default 0,

  categoria enum('di', 'of', 'do') null,

  usuario_id int null,

  membro_id int not null,

  primary key (oferta_id),

  index fk_oferta_usuario1_idx (usuario_id asc) visible,

  index fk_oferta_membro1_idx (membro_id asc) visible,

  constraint fk_oferta_usuario1

    foreign key (usuario_id)

    references igreja.usuario (usuario_id)

    on delete no action

    on update no action,

  constraint fk_oferta_membro1

    foreign key (membro_id)

    references igreja.membro (membro_id)

    on delete no action

    on update no action)

engine = innodb;

select * from usuario;

insert into usuario (login, senha) values ('root', 'root');
