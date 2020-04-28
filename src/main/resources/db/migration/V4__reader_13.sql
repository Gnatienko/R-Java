CREATE TABLE book_content (
    id BIGSERIAL NOT NULL,
    book_id BIGSERIAL NOT NULL,
    content TEXT,
    pagen BIGSERIAL NOT NULL,
    PRIMARY KEY(id)
);