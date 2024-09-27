CREATE TABLE IF NOT EXISTS usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
    );

INSERT INTO usuarios (nome, email) VALUES ('Alice Silva', 'alice@example.com');
INSERT INTO usuarios (nome, email) VALUES ('Bob Santos', 'bob@example.com');
INSERT INTO usuarios (nome, email) VALUES ('Carlos Oliveira', 'carlos@example.com');
INSERT INTO usuarios (nome, email) VALUES ('Diana Costa', 'diana@example.com');