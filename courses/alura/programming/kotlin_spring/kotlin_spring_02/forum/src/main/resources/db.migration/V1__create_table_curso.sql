CREATE TABLE curso(
    id BIGINT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO curso(id, nome, categoria) VALUES(1, 'Kotlin', 'Programação');
INSERT INTO curso(id, nome, categoria) VALUES(2, 'HTML', 'Font-end');