package com.gnatienko.reader.repository;

import com.gnatienko.reader.model.InternalDictionaryEntity;
import com.gnatienko.reader.model.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternalDictionary extends PagingAndSortingRepository<InternalDictionaryEntity, Long> { //наследование от похожего класса
    List<InternalDictionaryEntity> findAll();
}
