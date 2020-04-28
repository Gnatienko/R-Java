package com.gnatienko.reader.service;

import com.gnatienko.reader.model.BookContentEntity;
import com.gnatienko.reader.model.BookNamesEntity;
import com.gnatienko.reader.repository.BookContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookContentService {
    @Autowired
    private BookContentRepository repository;

    public BookContentEntity save(BookContentEntity entity) {
        return repository.save(entity);
    }

    public BookContentEntity get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found"));
    }

    public List<BookContentEntity> findByBookId(Long bookId){
        return repository.findByBookId(bookId );
    }
}
