package com.gnatienko.reader.repository;

import com.gnatienko.reader.model.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    List<UserEntity> findAll();
}
