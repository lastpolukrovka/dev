DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id         SERIAL NOT NULL,
    unique_id  VARCHAR NOT NULL,
    username   VARCHAR NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, unique_id)
);

INSERT INTO users (unique_id, username) VALUES 
('9ac307f5-f85b-4b45-a990-743fa0d1e59c', 'q'),
('8c23f644-58af-4be5-abcb-5ffe2982fa99', 'qw');