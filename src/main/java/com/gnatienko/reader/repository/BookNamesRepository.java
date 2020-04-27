package com.gnatienko.reader.repository;

import com.gnatienko.reader.model.BookNamesEntity;
import com.gnatienko.reader.model.InternalDictionaryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookNamesRepository extends PagingAndSortingRepository<BookNamesEntity,Long> {
    List<BookNamesEntity> findAll();
    List<BookNamesEntity> findByUserId(Long userId);

}
