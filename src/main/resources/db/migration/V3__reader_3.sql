CREATE TABLE book_names (
    id BIGSERIAL NOT NULL,
    user_id BIGSERIAL NOT NULL,
    name VARCHAR(50),
    PRIMARY KEY(id)
);