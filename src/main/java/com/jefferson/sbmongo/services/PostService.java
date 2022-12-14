package com.jefferson.sbmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jefferson.sbmongo.domain.Post;
import com.jefferson.sbmongo.repository.PostRepository;
import com.jefferson.sbmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = this.repository.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public List<Post> findByTitle(String text) {
		System.out.println(text);
		return this.repository.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
		return repository.fullSearch(text, minDate, maxDate);
	}
}
