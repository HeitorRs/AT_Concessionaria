CREATE TABLE IF NOT EXISTS veiculo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(10) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    ano VARCHAR(4) NOT NULL
);

INSERT INTO veiculo (placa, modelo, marca, ano) VALUES ('DEF-5678', 'Corolla', 'Toyota', '2021');
INSERT INTO veiculo (placa, modelo, marca, ano) VALUES ('GHI-9012', 'Focus', 'Ford', '2019');