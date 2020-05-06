package com.gnatienko.reader.repository;

import com.gnatienko.reader.model.InternalDictionaryEntity;
import com.gnatienko.reader.model.LearnedWordEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface LearnedWordsRepository extends PagingAndSortingRepository<LearnedWordEntity,Long> {
    List<LearnedWordEntity> findByUserId (Long userId);
    Optional<LearnedWordEntity> findByUserIdAndWordId(Long userId, Long wordId);
    List<LearnedWordEntity> findAll();

}
