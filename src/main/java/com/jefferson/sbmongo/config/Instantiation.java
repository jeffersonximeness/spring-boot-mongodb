package com.jefferson.sbmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jefferson.sbmongo.domain.Post;
import com.jefferson.sbmongo.domain.User;
import com.jefferson.sbmongo.repository.PostRepository;
import com.jefferson.sbmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		User maria = new User(null, "Maria", "maria@gmail.com");
		User joao = new User(null, "João", "joao@gmail.com");
		User bob = new User(null, "Bob", "bob@gmail.com");
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar pra Dubai! Até logo!", maria);
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Está fazendo um bom clima.", maria);
		
		userRepository.saveAll(Arrays.asList(maria, joao, bob));
		postRepository.saveAll(Arrays.asList(p1, p1));
	}

}
