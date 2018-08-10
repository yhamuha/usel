package com.usel.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usel.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}