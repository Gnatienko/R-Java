package com.gnatienko.reader.repository;

import com.gnatienko.reader.model.LearnedWordEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LearnedWordsRepository extends PagingAndSortingRepository<LearnedWordEntity,Long> {
    List<LearnedWordEntity> findByUserId (Long userId);
}
