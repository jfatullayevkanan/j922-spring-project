package com.example.j922springproject.dao.repository;

import com.example.j922springproject.dao.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


    Optional<UserEntity> findByUsername(String username);
}
