package com.devcreativa.restful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcreativa.restful.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}

