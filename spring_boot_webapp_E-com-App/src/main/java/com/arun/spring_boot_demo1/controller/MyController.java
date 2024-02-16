package com.arun.spring_boot_demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arun.spring_boot_demo1.DAO.DAO;
import com.arun.spring_boot_demo1.entity.Items;
import com.arun.spring_boot_demo1.entity.UserDTO;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
public class MyController {
	@Autowired
	private DAO dao;
	@GetMapping("/")
	public String link() {
		return "index";
	}
	@GetMapping("/registration")
	public String registration(UserDTO dto) {
		return "index2";
	}
	@GetMapping("/regForm")
	public String regForm(@ModelAttribute UserDTO dto) {
		dao.saveDTO(dto);
		return "index3";
		
	}
//	@GetMapping(value="/login")
//	public ModelAndView login(@RequestParam String name, @RequestParam int password) {
//		if(password==(1234)) {
//			return new ModelAndView("index4","msg", "login success, Mr. "+name);
//		}
//		return new ModelAndView("index4", "msg","Login failed ,Mr. "+name);
//		
//	}
	@GetMapping(value="/login")
	public String login1(@RequestParam String name, @RequestParam int password, HttpServletRequest request, Model model) {
		UserDTO dto = dao.login1(name,password);
		if(dto!=null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("name", dto);
		
			model.addAttribute("msg",dto);
			System.out.println("Login success");
			System.out.println(dto.getName());
			 List<Items> read =  dao.read();
			 System.out.println(read);
			model.addAttribute("read", read);
			
			return "index5";
		}else {
			System.out.println("login failed");
			return "index6";
		}
		
	}
	@GetMapping("/item")
	public String item() {
		return "index3";
	}
	@GetMapping("/itemForm")
	public String itemForm(@ModelAttribute Items itm) {
		dao.saveItm(itm);
		return "index7";
	}
	
	
	@GetMapping("/addCard/{id}")	// ====================Add to Card======================
	public String addCard(@PathVariable int id, HttpServletRequest request) {
		
		  HttpSession session = request.getSession(false);
		  UserDTO dto = (UserDTO) session.getAttribute("name");
		 System.out.println("Session======="+dto);
		
		dao.addItem(id,dto);
		
		
		
		return "resp6";
	}
	
	@GetMapping("/card")		//=====================My Card=====================
	public ModelAndView card(HttpServletRequest request, Model model) {
		
		 HttpSession session = request.getSession(false);
		 UserDTO dto = (UserDTO) session.getAttribute("name");
		
	
		model.addAttribute("user", dto);
		
		 UserDTO fetchal = dao.fetchall( dto);
		 List<Items> item = fetchal.getItem();
		
		
		
		
		
		return new ModelAndView("resp8", "list" , item);
	}
	
	
	
	
	
	@GetMapping("/order")
	public String confirm(HttpServletRequest request ) {
		HttpSession session = request.getSession(false);
		
	
		
		return "resp10";
	}
	
	
	
	
	
	
	
	
	  // Read
	  
		/*
		 * @GetMapping("/link2") public ModelAndView link2() { List<Items> read =
		 * dao.read(); System.out.println(read); return new
		 * ModelAndView("index3","user",read);
		 * 
		 * 
		 * }
		 */
	 @GetMapping("/logout")
	  public String logout(HttpServletRequest request) {
		  HttpSession session = request.getSession(false);
		  session.invalidate();
		  return "logout";
	  }
	 
	  
	 
}
               