package com.arun.spring_boot_demo1.DAO;


import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.arun.spring_boot_demo1.entity.Items;
import com.arun.spring_boot_demo1.entity.UserDTO;
import com.arun.spring_boot_demo1.model.ItemRepo;
import com.arun.spring_boot_demo1.model.jpaRepo;
@Component
public class DAO {
	@Autowired
	private jpaRepo repo;
	@Autowired
	private ItemRepo iRepo;
	public void saveDTO(UserDTO dto) {
		repo.save(dto);
		
	}
	public UserDTO login1(String name,int password) {
	UserDTO findByName = repo.findByName(name,password);
	System.out.println(findByName);
	return findByName;
		
	}
	
	/*
	 * public List<UserDTO> fetchItem() { List<UserDTO> findAll = repo.findAll();
	 * return findAll; }
	 */
	 
	
	  public void addItem(int id, UserDTO dto) { 
		Items item = iRepo.findById(id).orElse(null);
	  UserDTO dto2 =  repo.findById(dto.getId()).orElse(null);
	  dto2.getItem().add(item);
	  repo.save(dto2);
	 
	  
	  }
	 
	
	
	  public List<Items> read() { 
		List<Items> read = iRepo.findAll(); 
	   return read;
	 
	  
	  }
	 
	public void saveItm(Items itm) {
		iRepo.save(itm);
				
	}
	public UserDTO fetchall(UserDTO dto) {
		UserDTO findById = repo.findById(dto.getId()).orElse(null);
		return findById;
	}
	

}
 