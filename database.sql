create database cubos;
create table cubo(id int(11) not null auto_increment, nome varchar(100) not null, tamanho varchar(10) not null, tipo varchar(20) not null, dificuldade varchar(20) not null, imagem varchar(255) null, preco double, primary key(id));

INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('2x2x1','2','normal','facil','2x2x1',40);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('2x2x2','2','normal','facil','2x2x2',50);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x2','3','normal','facil','3x3x2',54);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x3','3','normal','normal','3x3x3',62);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x3A','3','normal','normal','3x3x3A',57);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x3B','3','incomum','normal','3x3x3B',42);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x3B2','3','incomum','normal','3x3x3B2',35);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x3E','3','incomum','normal','3x3x3E',49);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x3EG','3','incomum','normal','3x3x3EG',60);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x3I','3','incomum','normal','3x3x3I',70);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x3N','3','incomum','normal','3x3x3N',55);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('3x3x3S','3','incomum','normal','3x3x3S',46);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('4x4x4','4','normal','dificil','4x4x4',63);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('5x5x5','5','normal','dificil','5x5x5',83);
INSERT INTO cubo( nome, tamanho, tipo, dificuldade, imagem, preco ) 
VALUES('7x7x7','7','normal','dificil','7x7x7',90);
