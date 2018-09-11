package com.usel.app.repository;


import java.util.Optional;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.User;

@SpringBootApplication
public interface UserRepository extends JpaRepository<User, Integer> {

	void save(Optional<User> user);

}