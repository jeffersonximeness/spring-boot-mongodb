package com.jefferson.sbmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jefferson.sbmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
