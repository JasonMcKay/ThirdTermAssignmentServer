package com.restful_server.webserver.api;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restful_server.webserver.model.User;
import com.restful_server.webserver.service.UserService;


@SuppressWarnings("all")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/api/users", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<User>> getUsers(){
		Collection<User> users = userService.findAll();
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="api/users/{username}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("username") String username){
		System.out.println(username);
		User user = userService.findOne(username);
		if(user == null){
			System.out.println("user is null");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		System.out.println("user is not null" + user.getPassword());
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@RequestMapping(value="api/users/verify/{username}/{password}", method=RequestMethod.POST)
	public ResponseEntity<User> getUser(@PathVariable("username") String username, @PathVariable("password") String password){
		System.out.println(username + "**G*" + password);
		User findUser = userService.findOne(username);
		if(findUser == null){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}else{
			if(findUser.getPassword().equals(password)){
				return new ResponseEntity<User>(HttpStatus.ACCEPTED);
			}else{
				return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
			}
		}
	}
	
	@RequestMapping(value="api/users", method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		System.out.println(user.getUsername() + "**C*" + user.getPassword());
		User newUser = userService.create(user);
		System.out.println(newUser.getUsername() + "*N*C*" + newUser.getPassword());
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
}
