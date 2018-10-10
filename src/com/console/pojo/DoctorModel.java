package com.console.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorModel {
	
	SimpleDateFormat date = new SimpleDateFormat("HH:mm");
	
	private String firstName;
	private String lastName;
	private String specialization;
	private Date workingHourStarts;
	private Date workingHourEnds;
	private int consultingMinutes;
	
	public DoctorModel() { }
	
	public DoctorModel(String firstName, String lastName, String specialization, Date workingHourStarts, Date workingHourEnds, int consultingMinutes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialization = specialization;
		this.workingHourStarts = workingHourStarts;
		this.workingHourEnds = workingHourEnds;
		this.consultingMinutes = consultingMinutes;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Date getWorkingHourStarts() {
		return workingHourStarts;
	}

	public void setWorkingHourStarts(String workingHourStarts) throws ParseException{
		this.workingHourStarts = date.parse(workingHourStarts);
	}

	public Date getWorkingHourEnds() {
		return workingHourEnds;
	}

	public void setWorkingHourEnds(String working_Hour_Ends) throws ParseException{
		this.workingHourEnds = date.parse(working_Hour_Ends);
	}

	public int getConsultingMinutes() {
		return consultingMinutes;
	}

	public void setConsultingMinutes(int consultingMinutes) {
		this.consultingMinutes = consultingMinutes;
	}
	
}