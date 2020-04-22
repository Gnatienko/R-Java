CREATE TABLE reader_user (
    id BIGSERIAL NOT NULL,
    login VARCHAR(50),
    password VARCHAR(50),
    name VARCHAR(50),
    PRIMARY KEY(id)
);