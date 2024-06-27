package dtoclasses;

import java.util.ArrayList;

public class PassengerDTO {
	int passengerId;
	String PassengerName;
	String gender;
	int age;
	private int busNo;
	private int seatNo;
	private String from;
	private String to;
	private String journeyDate;
	private String departureTime;
	private String arrivalTime;
	public PassengerDTO(int passengerId, String passengerName, String gender, int age, int busNo, int seatNo,
			String from, String to, String journeyDate, String departureTime, String arrivalTime) {
		this.passengerId = passengerId;
		PassengerName = passengerName;
		this.gender = gender;
		this.age = age;
		this.busNo = busNo;
		this.seatNo = seatNo;
		this.from = from;
		this.to = to;
		this.journeyDate = journeyDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return PassengerName;
	}
	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
	
	
	
	

}
