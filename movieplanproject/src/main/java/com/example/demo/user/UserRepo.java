package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value="select * from User where username=?",nativeQuery = true)
	public User findbyusername(String username);
}
