CREATE TABLE historico_armas (
    identificaçao SERIAL PRIMARY KEY,
    nome_personagem VARCHAR(100) NOT NULL,
    nome_arma VARCHAR(100) NOT NULL,
    usos INT NOT NULL,
    mapa VARCHAR(100) NOT NULL
);
