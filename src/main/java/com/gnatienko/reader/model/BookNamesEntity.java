package com.gnatienko.reader.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_names")
public class BookNamesEntity {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Creating new IDs
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "name")
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookNamesEntity that = (BookNamesEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name);
    }
}
