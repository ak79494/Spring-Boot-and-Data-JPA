package com.arun.spring_boot_demo1.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arun.spring_boot_demo1.entity.UserDTO;                                                             

public interface jpaRepo extends JpaRepository<UserDTO, Integer> {
@Query("SELECT e FROM UserDTO e WHERE e.name =:name and e.password=:password")
	UserDTO findByName(String name, int password);

	

}
