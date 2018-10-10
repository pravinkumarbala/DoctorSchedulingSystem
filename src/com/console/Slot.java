package com.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.console.pojo.DoctorModel;
import com.console.pojo.AppointmentModel;

public class Slot extends Doctor{
	
	AppointmentModel apptModel = new AppointmentModel();
	
	List<DoctorModel> doctors = new LinkedList<>();
	static File book = new File("Files/BookedSlots.txt");
	
	@Override
	void mapDoctors() {
		try {
			for(int i = 1; i < listDoctors.size(); i++) {
				String[] dd = listDoctors.get(i).split("\t");
				doctors.add(new DoctorModel(dd[0], dd[1], dd[2], date.parse(dd[3]), date.parse(dd[4]), Integer.parseInt(dd[5])));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	void generateSlots(int number) {
		try {
			Set<String> slots = new HashSet<>();
			br = new BufferedReader(new FileReader(book));
			Calendar cal = Calendar.getInstance();
			Calendar endCal = Calendar.getInstance();
			cal.setTime(doctors.get(number).getWorkingHourStarts());
			endCal.setTime(doctors.get(number).getWorkingHourEnds());
			String line = br.readLine();
			while(line != null) {
				String[] details = line.split("\t");
				if(details[0].equals(doctors.get(number).getFirstName()) 
						&& 
						details[1].equals(doctors.get(number).getLastName()) ) {
					slots.add(details[2]);
				}
				line = br.readLine();
			}
			String slotTime = date.format(cal.getTime());
			while(slotTime.compareTo(date.format(endCal.getTime())) < 0 ) {
				if(slots.contains(slotTime)) {
					System.out.println("Slot booked");
				} else {
					System.out.println(slotTime);
				}
				cal.add(Calendar.MINUTE, doctors.get(number).getConsultingMinutes());
				slotTime = date.format(cal.getTime());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean bookingAppointment(int number) {
		try {
			FileWriter fw = new FileWriter(book, true);
			br = new BufferedReader(new FileReader(book));
			if(br.readLine() == null) {
				fw.write("Fname \t" + 
						"Lname \t" +
						"ExistSlot \t" +
						"CustName \t" +
						"CustAddr \t" +
						"CustPNo \t" +
						"CustEmail \n");
			}
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter the customer name : ");
			apptModel.setCustName(br.readLine());
			
			System.out.print("Enter the customer Addr : ");
			apptModel.setCustAddr(br.readLine());
			
			System.out.print("Enter the customer ph_no : ");
			apptModel.setCustPhone(Long.parseLong(br.readLine()));
			
			System.out.print("Enter the customer email : ");
			apptModel.setCustEmail(br.readLine());
			
			fw.write(doctors.get(number).getFirstName() 
					+ "\t" + doctors.get(number).getLastName() 
					+ "\t" + date.format(apptModel.getBookedSlot())
					+ "\t" + apptModel.getCustName()
					+ "\t" + apptModel.getCustAddr()
					+ "\t" + apptModel.getCustPhone()
					+ "\t" + apptModel.getCustEmail()
					+ "\n");
			fw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}