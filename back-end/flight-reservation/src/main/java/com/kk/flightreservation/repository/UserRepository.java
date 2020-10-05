package com.kk.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kk.flightreservation.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// By name Spring data automatically fires the select query based on the input
	// param(email) and the same name is exist in the <User, Long>
	User findByEmail(String email);

}
