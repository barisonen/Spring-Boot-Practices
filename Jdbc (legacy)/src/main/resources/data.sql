CREATE TABLE IF NOT EXISTS user (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO user (name) VALUES ('baris'), ('osman');