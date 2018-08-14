package com.usel.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	// public List<User> getUser();
	public List<User> findAll();
	
	// public void postUser();
	public void saveAll(List<User> entity);
	
	// public User getUserById(User id);
	public Optional<User> findById();
	
	// public void putUserById(User id);
	//public void save(id);
	//public <S extends T> S save(S entity);
	public User save(User user);
	
	// public void deleteUserById(User id);
	// done
	public void deleteById();
	
}