package com.olivestays.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olivestays.model.Admin;

public interface AdminDao extends JpaRepository<Admin,Integer>{
	Optional<Admin> findByEmail(String email);
}
