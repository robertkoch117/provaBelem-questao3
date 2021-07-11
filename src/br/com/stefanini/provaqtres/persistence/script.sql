CREATE DATABASE bdquestao3;

USE bdquestao3;

drop table venda;
drop table produto;
drop table itemProduto;
drop table endereco;
drop table cliente;

CREATE TABLE cliente(idCliente int PRIMARY KEY auto_increment,
					nome VARCHAR(50),
					email VARCHAR(50),
					senha VARCHAR(50),
					uuid varchar(50));
					
CREATE TABLE endereco(idEndereco int PRIMARY KEY auto_increment,
					bairro varchar(50), 
					cidade varchar(50),
					cep varchar(50),
					id_cliente int unique,
					FOREIGN KEY(id_cliente) references cliente(idCliente));
					
CREATE TABLE produto(idProduto int PRIMARY KEY auto_increment,
					 nome VARCHAR(50),
					 preco double,
					 qtdEstoque int);
					 
CREATE TABLE venda(idVenda int PRIMARY KEY auto_increment,
				   id_cliente int not null,
				   dataVenda Date,
				   valorVenda double,
				   FOREIGN KEY (id_cliente) REFERENCES cliente(idCliente));

CREATE TABLE itemProduto(idItemProduto int PRIMARY KEY auto_increment,
					id_venda int not null,
					id_produto int not null,
					quantidade int,
					precoAcumulado double,
					FOREIGN KEY (id_produto) REFERENCES produto(idProduto),
					FOREIGN KEY (id_venda) REFERENCES venda(idVenda));
						 
