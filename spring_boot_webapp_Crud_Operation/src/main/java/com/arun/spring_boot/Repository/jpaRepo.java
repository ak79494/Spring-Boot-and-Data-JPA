package com.arun.spring_boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.spring_boot.model.UserDTO;

public interface jpaRepo extends JpaRepository<UserDTO, Integer> {


}
