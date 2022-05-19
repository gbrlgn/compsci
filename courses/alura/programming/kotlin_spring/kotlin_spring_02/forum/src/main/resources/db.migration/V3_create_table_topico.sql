CREATE TABLE topico(
    id BIGINT NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    mensagem VARCHAR(50) NOT NULL,
    data_criacao datetime NOT NULL,
    status varchar(20) NOT NULL,
    curso_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(curso_id) REFERENCES curso(id),
    FOREIGN KEY(usuario_id) REFERENCES usuario(id)
);

INSERT INTO topico(id, nome, email) VALUES(1, 'Bianca', 'bianca@email.com');