package com.arun.spring_boot.Crud_Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.arun.spring_boot.DAO.DAO;
import com.arun.spring_boot.model.UserDTO;
@Controller
public class MyController {
	@Autowired
	private DAO dao;
	@GetMapping("/")
	public String link1() {
		return "index";
	}
	@GetMapping("/registration")
	public String registration(@ModelAttribute UserDTO dto) {
		dao.saveDTO(dto);
		return "index2";
	}
	
}
