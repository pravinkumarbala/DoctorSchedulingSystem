package com.console.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentModel {
	
	SimpleDateFormat date = new SimpleDateFormat("HH:mm");
	
	private Date bookedSlot;
	private String custName;
	private String custAddr;
	private long custPhone;
	private String custEmail;
	
	public Date getBookedSlot() {
		return bookedSlot;
	}
	
	public void setBookedSlot(String bookedSlot) throws ParseException {
		this.bookedSlot = date.parse(bookedSlot);
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getCustAddr() {
		return custAddr;
	}
	
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	public long getCustPhone() {
		return custPhone;
	}
	
	public void setCustPhone(long custPhone) {
		this.custPhone = custPhone;
	}
	
	public String getCustEmail() {
		return custEmail;
	}
	
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
}