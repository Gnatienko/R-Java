CREATE TABLE learned_words (
    id BIGSERIAL NOT NULL,
    user_id BIGSERIAL NOT NULL,
    word_id BIGSERIAL NOT NULL,
    PRIMARY KEY(id)
);