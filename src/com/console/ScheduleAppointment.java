package com.console;

import java.text.ParseException;
import java.util.Scanner;

import com.console.Slot;
import com.console.pojo.DoctorModel;

public class ScheduleAppointment {
	
	public static void main(String[] args) {
		Slot slot = new Slot();
		Scanner scan = new Scanner(System.in);
		slot.retDoctor();
		slot.mapDoctors();
		int choice = 0;
		int exit = slot.doctors.size() + 1;
		do {
			System.out.println("Book Appointment");
			System.out.println("****************");
			int i = 1;
			for(DoctorModel show: slot.doctors) {
				System.out.print(i + ": " + show.getFirstName() + " " + show.getLastName() + "\t");
				i++;
			}
			System.out.println(exit + ": exit");
			System.out.print("Choose the doctor from the list : ");
			choice = scan.nextInt();
			if(choice == exit) {
				// When the customer press exit option
				System.out.println("Thanks for visiting");
			} else if(choice < exit) {
				// Customer chose the doctor from the list
				try {
					slot.generateSlots(choice - 1);
					System.out.print("Enter the slot time: ");
					slot.apptModel.setBookedSlot(scan.next());
					if(slot.bookingAppointment(choice - 1)) {
						System.out.println("Appointment is booked");
					} else {
						System.out.println("Appointment is not booked");
					}
				} catch (NumberFormatException | ParseException e) {
					e.printStackTrace();
				}
			} else {
				// When the customer press other or wrong option
				System.out.println("Sorry you have selected the wrong option");
			}
		}while(choice != exit);
		
		scan.close();
	}
	
}