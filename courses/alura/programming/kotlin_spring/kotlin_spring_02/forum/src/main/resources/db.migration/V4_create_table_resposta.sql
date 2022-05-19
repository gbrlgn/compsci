CREATE TABLE reposta(
    id BIGINT NOT NULL,
    mensagem VARCHAR(300) NOT NULL,
    data_criacao datetime NOT NULL,
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    solucao INT(1) NOT NULL
    PRIMARY KEY(id),
    FOREIGN KEY(topico_id) REFERENCES topico(id),
    FOREIGN KEY(autor_id) REFERENCES autor(id)
);

INSERT INTO curso(id, nome, categoria) VALUES(1, 'Kotlin', 'Programação');