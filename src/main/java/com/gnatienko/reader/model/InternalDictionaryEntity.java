package com.gnatienko.reader.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reader_internal_dictionary")
public class InternalDictionaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Creating new IDs
    private Long id;

    @Column(name = "english")
    private String english;

    @Column(name = "russian")
    private String russian;

    public InternalDictionaryEntity() {
    }

    public InternalDictionaryEntity(String english, String russian) {
        this.english = english;
        this.russian = russian;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getRussian() {
        return russian;
    }

    public void setRussian(String russian) {
        this.russian = russian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternalDictionaryEntity that = (InternalDictionaryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(english, that.english) &&
                Objects.equals(russian, that.russian);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, english, russian);
    }
}
