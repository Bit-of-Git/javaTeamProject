package application;

import javafx.beans.property.SimpleStringProperty;



public class Flight {
	
	private SimpleStringProperty leavingTime, arriveTime, to, from, day;
	private int flightID, cost, flightNum, capacity;
	
	public Flight(int flightID, int flightNum, int capacity, int cost, String day, String to, String from, String arriveTime, String leavingTime) {
		this.flightID = flightID;
		this.flightNum = flightNum;
		this.capacity =capacity;
		this.cost = cost;
		this.day = new SimpleStringProperty(day);
		this.leavingTime = new SimpleStringProperty(leavingTime);
		this.arriveTime = new SimpleStringProperty(arriveTime);
		this.to = new SimpleStringProperty(to);
		this.from = new SimpleStringProperty(from);
	}
	
	public String getDay() {
		return day.get();
	}

	public void setDay(SimpleStringProperty day) {
		this.day = day;
	}


	public String getLeavingTime() {
		return leavingTime.get();
	}

	public void setLeavingTime(SimpleStringProperty leavingTime) {
		this.leavingTime = leavingTime;
	}

	public String getArriveTime() {
		return arriveTime.get();
	}

	public void setArriveTime(SimpleStringProperty arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getTo() {
		return to.get();
	}

	public void setTo(SimpleStringProperty to) {
		this.to = to;
	}

	public String getFrom() {
		return from.get();
	}

	public void setFrom(SimpleStringProperty from) {
		this.from = from;
	}

	public int getFlightID() {
		return flightID; 
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	
	public int getFlightNum() {
		return flightNum; 
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}
	
	public int getCost() {
		return cost; 
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCapacity() {
		return capacity; 
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
