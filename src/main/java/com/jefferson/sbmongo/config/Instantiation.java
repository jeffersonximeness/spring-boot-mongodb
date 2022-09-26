package com.jefferson.sbmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jefferson.sbmongo.domain.User;
import com.jefferson.sbmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		User maria = new User(null, "Maria", "maria@gmail.com");
		User joao = new User(null, "João", "joao@gmail.com");
		User bob = new User(null, "Bob", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, joao, bob));
	}

}
