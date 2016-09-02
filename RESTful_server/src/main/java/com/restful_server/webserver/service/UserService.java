package com.restful_server.webserver.service;

import java.util.Collection;
import com.restful_server.webserver.model.User;

public interface UserService {
	
	Collection<User> findAll();
	User findOne(String username);
	User create(User user);
}
