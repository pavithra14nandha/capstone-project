package com.example.demo.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	@Query(value="select * from admin where name=?",nativeQuery = true)
	public Admin findbyname(String name);
}
