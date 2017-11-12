/*Criando o banco de dados*/
CREATE DATABASE projetolivrosdb;

/*Criando as tabelas*/

CREATE TABLE leitor(
    codigo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    data_nascimento DATETIME
);

CREATE TABLE livros(
    codigo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50) NOT NULL unique,
    autor VARCHAR(50) NOT NULL,
    tema VARCHAR(20),
    numero_paginas INT NOT NULL
);


CREATE TABLE leitor_livro(
    cod_leitor VARCHAR(50) NOT NULL,
    cod_livro INT NOT NULL,
    estado ENUM('Lendo','Lido','Na Fila') NOT NULL,
    FOREIGN KEY(cod_leitor) REFERENCES leitor(codigo),
    FOREIGN KEY(cod_livro) REFERENCES livro(codigo)
);

