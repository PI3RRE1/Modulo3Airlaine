DROP DATABASE IF EXISTS airlaine;
CREATE DATABASE airlaine;
USE airlaine;

create table if not exists cliente(
  id_cliente int primary key not null auto_increment,
  cpf varchar(11) not null,
  nome varchar(50) not null,
  endereco varchar(100) not null,
  cep varchar(8) not null,
  telefone varchar(14) not null,
  email varchar(100) unique not null,
  senha varchar(50) not null
  );

 create table if not exists voo(
  id_voo int primary key not null auto_increment,
  numero_assento int not null,
  origem varchar(100) not null,
  destino varchar(100) not null,
  companhia_aerea varchar(50) not null,
  aeroporto varchar(50) not null,
  data_embarque date not null,
  preco double not null
  );  
  
  create table if not exists reserva(
  id_reserva int primary key not null auto_increment,
  data_reserva date not null,
  num_pessoas int not null,
  cancelado boolean not null,
  id_cliente int not null,
  id_voo int not null,
  foreign key (id_cliente) references cliente(id_cliente),
  foreign key (id_voo) references voo(id_voo)
  );
  
  create table if not exists contato(
  id_contato int primary key not null auto_increment,
  nome varchar(50) not null,
  telefone varchar(14) not null,
  email varchar(100) unique not null,
  assunto varchar(50) not null,
  mensagem varchar(500) not null
  );
  
  ALTER TABLE `airlaine`.`reserva` 
DROP FOREIGN KEY `reserva_ibfk_1`,
DROP FOREIGN KEY `reserva_ibfk_2`;
ALTER TABLE `airlaine`.`reserva` 
ADD CONSTRAINT `reserva_ibfk_1`
  FOREIGN KEY (`id_cliente`)
  REFERENCES `airlaine`.`cliente` (`id_cliente`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `reserva_ibfk_2`
  FOREIGN KEY (`id_voo`)
  REFERENCES `airlaine`.`voo` (`id_voo`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
 insert into cliente values("");
 insert into voo values(null,"");
 select * from cliente;
 select * from voo;
