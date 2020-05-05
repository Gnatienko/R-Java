package com.gnatienko.reader.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "learned_words")
public class LearnedWordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Creating new IDs
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "wordId")
    private Long wordId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWordId() {
        return wordId;
    }

    public void setWordId(Long wordId) {
        this.wordId = wordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LearnedWordEntity that = (LearnedWordEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(wordId, that.wordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, wordId);
    }
}
