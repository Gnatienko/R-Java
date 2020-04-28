package com.gnatienko.reader.model;

import org.apache.commons.lang3.tuple.Pair;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "book_content")
public class BookContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Creating new IDs
    private Long id;

    @Column(name = "bookId")
    private Long bookId;

    @Column(name = "content")
    private String content;

    @Column(name = "pageN")
    private Long pageN;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPageN() {
        return pageN;
    }

    public void setPageN(Long pageN) {
        this.pageN = pageN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookContentEntity that = (BookContentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(bookId, that.bookId) &&
                Objects.equals(content, that.content) &&
                Objects.equals(pageN, that.pageN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, content, pageN);
    }
}
