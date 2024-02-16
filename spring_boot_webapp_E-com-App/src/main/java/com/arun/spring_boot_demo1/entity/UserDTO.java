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
public class UserDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String age;
	private int password;
	private String address;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cus_item", joinColumns = @JoinColumn(name="cid"), inverseJoinColumns = @JoinColumn(name="iid"))
	private List<Items> item;
	public List<Items> getItem() {
		return item;
		
	}
	
	public void setItem(List<Items> item) {
		this.item = item;
	}

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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password + ", address=" + address
				+ "]";
	}
	
	
}
