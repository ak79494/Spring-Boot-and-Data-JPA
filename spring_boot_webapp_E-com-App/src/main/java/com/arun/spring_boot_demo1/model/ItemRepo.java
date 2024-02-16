package com.arun.spring_boot_demo1.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.spring_boot_demo1.entity.Items;

public interface ItemRepo extends JpaRepository<Items, Integer> {

}
