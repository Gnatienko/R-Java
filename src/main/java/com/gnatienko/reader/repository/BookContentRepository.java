package com.gnatienko.reader.repository;

import com.gnatienko.reader.model.BookContentEntity;
import com.gnatienko.reader.model.BookNamesEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookContentRepository extends PagingAndSortingRepository<BookContentEntity,Long> {
    List<BookContentEntity> findByBookIdAndPageNumber (Long bookId, Long pageNumber);

}
