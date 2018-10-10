package com.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.console.pojo.*;

abstract class Doctor implements DoctorSpecialist{
	
	public BufferedReader br;
	static DoctorModel doctorModel = new DoctorModel();
	static SimpleDateFormat date = new SimpleDateFormat("HH:mm");
	static File file = new File("Files/Doctors.txt");
	static List<String> listDoctors = new ArrayList<>();	
	
	abstract void mapDoctors();
	abstract void generateSlots(int number);
	
	@Override
	public void addDoctor() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter the first name : ");
			doctorModel.setFirstName(br.readLine());
			
			System.out.print("Enter the last name : ");
			doctorModel.setLastName(br.readLine());
			
			DoctorSpecialist.showSpecialization();
			System.out.println("\nAssign the specialization for the doctor: ");
			doctorModel.setSpecialization(DoctorSpecialist.selectSpecialization(Integer.parseInt(br.readLine())));
			
			System.out.print("Enter the start time of Working hour : ");
			doctorModel.setWorkingHourStarts(br.readLine());
			
			System.out.print("Enter the end time of Working hour : ");
			doctorModel.setWorkingHourEnds(br.readLine());
			
			System.out.print("Enter the Consulting Time : ");
			doctorModel.setConsultingMinutes(Integer.parseInt(br.readLine()));
			
			FileWriter fw = new FileWriter(file, true);
			br = new BufferedReader(new FileReader(file));
			if(br.readLine() == null) {
				fw.write("FName \t" 
						+ "LName \t"
						+ "Special \t"
						+ "SWH \t"
						+ "EWH \t"
						+ "CT \n"
						);
			}
			
			fw.write(doctorModel.getFirstName() + 
					"\t" + doctorModel.getLastName() + 
					"\t" + doctorModel.getSpecialization() +
					"\t" + date.format(doctorModel.getWorkingHourStarts()) + 
					"\t" + date.format(doctorModel.getWorkingHourEnds()) + 
					"\t" + doctorModel.getConsultingMinutes() +
					"\n" );
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void retDoctor() {
		try {
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				listDoctors.add(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}