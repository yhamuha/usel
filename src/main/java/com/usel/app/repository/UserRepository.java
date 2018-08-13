package com.usel.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> getUser();
	public void postUser();
	public User getUserById(User id);
	public void putUserById(User id);
	public void deleteUserById(User id);
	
}