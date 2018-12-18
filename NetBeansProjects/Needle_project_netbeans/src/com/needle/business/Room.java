package com.needle.business;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Room {
	private IntegerProperty roomNumber = new SimpleIntegerProperty(); 
	private StringProperty type = new SimpleStringProperty();
	private DoubleProperty price = new SimpleDoubleProperty();
	private StringProperty status = new SimpleStringProperty();
	
	
	public Room() {
		
	}


	public Room(int roomNumber, String type, double price, String status) {
		super();
		this.roomNumber.setValue(roomNumber);
		this.type.setValue(type);
		this.price.setValue(price);
		this.status.setValue(status);
	}


	/**
	 * @return the id
	 */
	public int getRoomNumber() {
		return roomNumber.getValue();
	}


	/**
	 * @param id the id to set
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber.setValue(roomNumber);;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type.getValue();
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type.setValue(type);
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price.getValue();
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price.setValue(price);
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return status.getValue();
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status.setValue(status);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [id=" + roomNumber + ", type=" + type + ", price=" + price + ", status=" + status + "]";
	}

	
}
