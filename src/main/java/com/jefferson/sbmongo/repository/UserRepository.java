package com.jefferson.sbmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jefferson.sbmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
