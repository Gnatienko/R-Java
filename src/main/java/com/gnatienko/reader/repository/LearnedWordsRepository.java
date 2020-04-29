package com.gnatienko.reader.repository;

import com.gnatienko.reader.model.BookContentEntity;
import com.gnatienko.reader.model.LearnedWordsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LearnedWordsRepository extends PagingAndSortingRepository<LearnedWordsEntity,Long> {
    List<LearnedWordsEntity> findByUserId (Long userId);
}
