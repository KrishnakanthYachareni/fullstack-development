package com.kk.clinicals.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kk.clinicals.model.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {

	List<ClinicalData> findByPatientIdAndComponentNameOrderByMeasuredDateTime(int patientId, String componentName);

}