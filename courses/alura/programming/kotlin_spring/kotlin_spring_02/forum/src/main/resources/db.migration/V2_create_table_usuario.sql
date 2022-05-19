CREATE TABLE usuario(
    id BIGINT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO usuario(id, nome, email) VALUES(1, 'Bianca', 'bianca@email.com');