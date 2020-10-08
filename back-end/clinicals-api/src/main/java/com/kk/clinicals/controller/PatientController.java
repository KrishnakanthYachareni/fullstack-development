package com.kk.clinicals.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.clinicals.model.ClinicalData;
import com.kk.clinicals.model.Patient;
import com.kk.clinicals.repo.PatientRepository;
import com.kk.clinicals.util.BMICalculator;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

	private PatientRepository patientRepo;
	private Map<String, String> filters = new HashMap<>();

	@Autowired
	public PatientController(PatientRepository patientRepo) {
		this.patientRepo = patientRepo;
	}

	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return patientRepo.findAll();
	}

	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable("id") int id) {
		return patientRepo.findById(id).orElse(null);
	}

	@PostMapping("/patients")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientRepo.save(patient);
	}

	@GetMapping("/patients/analyze/{id}")
	public Patient analyze(@PathVariable("id") int id) {
		Patient patient = patientRepo.findById(id).orElse(null);
		List<ClinicalData> clinicalData = patient.getClinicalData();
		List<ClinicalData> duplicateClinicalDa = new ArrayList<>(clinicalData);
		for (ClinicalData entry : duplicateClinicalDa) {

			if (filters.containsKey(entry.getComponentName())) {
				clinicalData.remove(entry);
				continue;
			} else {
				filters.put(entry.getComponentName(), null);
			}

			BMICalculator.calculateBMI(clinicalData, entry);
		}
		filters.clear();
		return patient;
	}
}
