/*
 * Copyright (c) 2020 Javatar LLC
 * All rights reserved.
 */
package com.gnatienko.reader.model;

import java.util.Objects;

/**
 * @author Svitlana Onyshchenko / Javatar LLC
 * @version 26-04-2020
 */
public class Word {

    private String origin;
    private String translation;
    private Long id;

    public Word(String origin, String translation, Long id) { // конструктор класса
        this.origin = origin;
        this.translation = translation;
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Word word = (Word) o;
        return Objects.equals(origin, word.origin) &&
                Objects.equals(translation, word.translation) &&
                Objects.equals(id, word.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, translation, id);
    }
}
