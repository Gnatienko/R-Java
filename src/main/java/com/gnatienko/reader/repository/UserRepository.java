package com.gnatienko.reader.repository;

import com.gnatienko.reader.model.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    List<UserEntity> findAll(); //Возвращает всех юзеров
    Optional<UserEntity> findByEmail(String email);
}
