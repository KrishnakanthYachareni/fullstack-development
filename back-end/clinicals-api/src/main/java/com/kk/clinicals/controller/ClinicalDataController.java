package com.kk.clinicals.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.clinicals.dto.ClinicalDataRequest;
import com.kk.clinicals.model.ClinicalData;
import com.kk.clinicals.model.Patient;
import com.kk.clinicals.repo.ClinicalDataRepository;
import com.kk.clinicals.repo.PatientRepository;
import com.kk.clinicals.util.BMICalculator;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {

	private ClinicalDataRepository clinicalDataRepository;
	private PatientRepository patientRepository;

	@Autowired
	public ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository) {
		this.clinicalDataRepository = clinicalDataRepository;
		this.patientRepository = patientRepository;
	}

	@PostMapping("/clinicals")
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		Patient patient = patientRepository.findById(request.getPatientId()).orElse(null);

		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);

		return clinicalDataRepository.save(clinicalData);
	}

	@GetMapping("/clinicals/{patientId}/{componentName}")
	public List<ClinicalData> getClinicalData(@PathVariable("patientId") int patientId,
			@PathVariable("componentName") String componentName) {

		if ("bmi".equals(componentName)) {
			componentName = "hw";
		}

		List<ClinicalData> clinicalData = clinicalDataRepository
				.findByPatientIdAndComponentNameOrderByMeasuredDateTime(patientId, componentName);
		List<ClinicalData> duplicateClinicalDa = new ArrayList<>(clinicalData);

		for (ClinicalData entry : duplicateClinicalDa) {
			BMICalculator.calculateBMI(clinicalData, entry);
		}
		return clinicalData;
	}
}
