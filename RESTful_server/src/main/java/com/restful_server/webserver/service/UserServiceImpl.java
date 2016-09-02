package com.restful_server.webserver.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restful_server.webserver.model.User;
import com.restful_server.webserver.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	public Collection<User> findAll() {
		Collection<User> users = userRepository.findAll();
		return users;
	}

	public User findOne(String username) {
		User user = userRepository.findOne(username);
		return user;
	}

	public User create(User user) {
		if(user.getUsername() == null){
			return null;
		}
		User newUser = userRepository.save(user);
		return newUser;
	}
}
