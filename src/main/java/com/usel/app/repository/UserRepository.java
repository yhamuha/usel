package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.usel.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public boolean existsByEmail(String email);
}


