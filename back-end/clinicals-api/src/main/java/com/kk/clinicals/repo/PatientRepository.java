package com.kk.clinicals.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kk.clinicals.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
