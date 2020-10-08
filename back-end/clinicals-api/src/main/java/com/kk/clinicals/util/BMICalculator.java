package com.kk.clinicals.util;

import java.util.List;

import com.kk.clinicals.model.ClinicalData;

public class BMICalculator {

	public static void calculateBMI(List<ClinicalData> clinicalData, ClinicalData entry) {
		if ("hw".equals(entry.getComponentName())) {
			String[] heightAndWeight = entry.getComponentValue().split("/");
			if (null != heightAndWeight && heightAndWeight.length > 1) {
				float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
				float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters * heightInMeters);
				ClinicalData bmiData = new ClinicalData();
				bmiData.setComponentName("bmi");
				bmiData.setComponentValue(Float.toString(bmi));
				clinicalData.add(bmiData);
			}
		}
	}
}
