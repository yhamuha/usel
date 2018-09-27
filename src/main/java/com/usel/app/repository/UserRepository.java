package com.usel.app.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.User;

@SpringBootApplication
public interface UserRepository extends JpaRepository<User, Integer>{
	public boolean existsByEmail(String email);
}


