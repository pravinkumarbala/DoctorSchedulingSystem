package com.console;

public interface DoctorSpecialist{
	
	// Array Variables
	String[] doctorSpecilization = {"CARDIOLOGISTS", 
									"DERMATOLOGISTS", 
									"GASTROENTEROLOGISTS", 
									"GENERAL_PHYSICIAN",
									"PATHOLOGISTS", 
									"RADIOLOGISTS"
									};
	// Methods
	public void addDoctor();
	public void retDoctor();
	
	// Default Methods
	static void showSpecialization() {
		int i = 1;
		for(String specialist: doctorSpecilization) {
			System.out.print(i + ": " + specialist + "\t");
			i++;
		}
	}
	
	static String selectSpecialization(int i) {
		return doctorSpecilization[i - 1];
	}
}