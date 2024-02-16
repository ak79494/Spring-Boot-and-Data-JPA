package com.arun.spring_boot_demo1.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	  @ManyToMany(cascade = CascadeType.ALL)
	  @JoinTable(name="cus_item", joinColumns = @JoinColumn(name="iid"),inverseJoinColumns = @JoinColumn(name="cid"))
	 private List<UserDTO> dto;
	public List<UserDTO> getDto() {
		return dto;
	}
	public void setDto(List<UserDTO> dto) {
		this.dto = dto;
	}
	 
	
}
