CREATE TABLE alteracoes (
    id             INTEGER NOT NULL,
    id_alteracao   INTEGER NOT NULL,
    data_pagam     DATE,
    data_venc      DATE,
    comentario     VARCHAR2(200),
    total_orc      NUMBER(15, 2),
    faturado       CHAR(1)
)
LOGGING;

ALTER TABLE alteracoes
    ADD CHECK ( faturado IN (
        'N',
        'S'
    ) );

ALTER TABLE alteracoes ADD CONSTRAINT alteracoes_pk PRIMARY KEY ( id_alteracao );

CREATE TABLE cliente (
    id             INTEGER NOT NULL,
    nome_cliente   VARCHAR2(60) NOT NULL,
    cpf            VARCHAR2(15) NOT NULL,
    data_nasc      DATE NOT NULL,
    telefone       VARCHAR2(20) NOT NULL,
    endereco       VARCHAR2(60) NOT NULL,
    cidade         VARCHAR2(50) NOT NULL,
    uf             VARCHAR2(20) NOT NULL,
    referencia     VARCHAR2(100) NOT NULL,
    sexo           VARCHAR2(1) NOT NULL
)


logging;

ALTER TABLE cliente
    ADD CHECK ( sexo IN (
        'F',
        'M'
    ) );

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( id );

CREATE TABLE itensorcamento (
    id          INTEGER NOT NULL,
    item        INTEGER NOT NULL,
    qtde_item   INTEGER,
    valor       NUMBER(15, 2) NOT NULL
)


logging;


ALTER TABLE itensorcamento ADD CONSTRAINT itensorcam_pk PRIMARY KEY ( id,
                                                                      item );

CREATE TABLE orcamento (
    id              INTEGER NOT NULL,
    cliente_orcam   INTEGER NOT NULL,
    data_pagam      DATE,
    data_venc       DATE NOT NULL,
    comentario_nf   VARCHAR2(200),
    total_orc       NUMBER(15, 2) NOT NULL,
    faturado        CHAR(1)
)


logging;

ALTER TABLE orcamento
    ADD CHECK ( faturado IN (
        'N',
        'S'
    ) );



CREATE INDEX orcamento__idx ON
    orcamento (
        cliente_orcam
    ASC );
        

ALTER TABLE orcamento ADD CONSTRAINT orcamento_pk PRIMARY KEY ( id );

CREATE TABLE produto (
    id            INTEGER NOT NULL,
    nome_item     VARCHAR2(50) NOT NULL,
    qtde_est      INTEGER NOT NULL,
    qtde_reserv   INTEGER,
    valor_unit    NUMBER(15, 2) NOT NULL
)


logging;

ALTER TABLE produto ADD CONSTRAINT produto_pk PRIMARY KEY ( id );

ALTER TABLE itensorcamento
    ADD CONSTRAINT itensorcam_orcamento_fk FOREIGN KEY ( id )
        REFERENCES orcamento ( id )
            ON DELETE CASCADE
    NOT DEFERRABLE;

ALTER TABLE itensorcamento
    ADD CONSTRAINT itensorcam_produto_fkv2 FOREIGN KEY ( id )
        REFERENCES produto ( id )
    NOT DEFERRABLE;

ALTER TABLE orcamento
    ADD CONSTRAINT orcamento_cliente_fk FOREIGN KEY ( cliente_orcam )
        REFERENCES cliente ( id )
    NOT DEFERRABLE;

ALTER TABLE alteracoes
    ADD CONSTRAINT table_6_orcamento_fk FOREIGN KEY ( id )
        REFERENCES orcamento ( id )
    NOT DEFERRABLE;