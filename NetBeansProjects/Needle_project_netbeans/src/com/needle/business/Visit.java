package com.needle.business;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Visit {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private Room room;
	private Guest guest;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Visit() {
	}

	public Visit(int id, Room room, Guest guest, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.id.setValue(id);
		this.room = room;
		this.guest = guest;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id.getValue();
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id.setValue(id);;
	}

	public double getTotal(int nights) {
		return room.getPrice()*nights;
	}
	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the guest
	 */
	public Guest getGuest() {
		return guest;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	/**
	 * @return the checkIn
	 */
	public LocalDate getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the checkOut
	 */
	public LocalDate getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Visit [id=" + id + ", room=" + room + ", guest=" + guest + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + "]";
	}
	
	
}
