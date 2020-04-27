CREATE TABLE book_names (
    id BIGSERIAL NOT NULL,
    userId BIGSERIAL NOT NULL,
    name VARCHAR(50),
    PRIMARY KEY(id)
);