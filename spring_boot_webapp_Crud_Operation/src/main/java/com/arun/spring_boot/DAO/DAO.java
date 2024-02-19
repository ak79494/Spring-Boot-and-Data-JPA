package com.arun.spring_boot.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arun.spring_boot.Repository.jpaRepo;
import com.arun.spring_boot.model.UserDTO;

@Component
public class DAO {
@Autowired
private jpaRepo repo;
	public void saveDTO(UserDTO dto) {
		repo.save(dto);
		
		
		
	}
       
}
     