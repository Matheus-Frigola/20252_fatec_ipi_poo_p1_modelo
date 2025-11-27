-- Active: 1762454782316@@pg-10ccdd47-professorbossini.e.aivencloud.com@12956@defaultdb
CREATE TABLE tb_pessoa(
  cod_pessoa SERIAL PRIMARY KEY,
  nome VARCHAR(200) NOT NULL,
  fone VARCHAR(200) NOT NULL,
  email VARCHAR(200) NULL
);

SELECT * FROM tb_pessoa;
CREATE TABLE tb_pet(
  cod_pet INT PRIMARY KEY,
  cod_pessoa INT,
  CONSTRAINT fk_pessoa FOREIGN KEY (cod_pessoa)
  REFERENCES tb_pessoa(codigo)

)

SELECT * FROM tb_pessoa INNER JOIN tb_pet
ON tb_pessoa.cod_pessoa = tb_pet.codigo_pessoa;


-- CREATE TABLE tb_teste(
--   cod_teste SERIAL PRIMARY KEY,
--   descricao VARCHAR(200) NOT NULL
-- );
-- INSERT INTO tb_teste(descricao) VALUES('testando');
-- SELECT * FROM tb_teste;