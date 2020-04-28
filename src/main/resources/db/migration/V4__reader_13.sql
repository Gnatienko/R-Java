CREATE TABLE book_content (
    id BIGSERIAL NOT NULL,
    book_id BIGSERIAL NOT NULL,
    content TEXT,
    page_n BIGSERIAL NOT NULL,
    PRIMARY KEY(id)
);