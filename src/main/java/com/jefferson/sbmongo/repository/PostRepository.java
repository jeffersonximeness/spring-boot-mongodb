package com.jefferson.sbmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jefferson.sbmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	List<Post> findByTitleContainingIgnoreCase(String text);
}
