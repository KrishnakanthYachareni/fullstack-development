package com.kk.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kk.flightreservation.entities.User;

public interface RoleRepository extends JpaRepository<User, Long> {
	
	
}
