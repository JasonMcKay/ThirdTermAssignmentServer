package com.restful_server.webserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.restful_server.webserver.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
