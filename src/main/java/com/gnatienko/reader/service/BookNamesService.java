package com.gnatienko.reader.service;

import com.gnatienko.reader.model.BookNamesEntity;
import com.gnatienko.reader.model.UserEntity;
import com.gnatienko.reader.repository.BookNamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookNamesService {
    @Autowired
    private BookNamesRepository repository;

    public BookNamesEntity save(BookNamesEntity entity) {
        return repository.save(entity);
    }

    public BookNamesEntity get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<BookNamesEntity> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public BookNamesEntity findByIdAndUserId (Long Id, Long UserId) {
        return repository.findByIdAndUserId(Id, UserId);
    }


}
