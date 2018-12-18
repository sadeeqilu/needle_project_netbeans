package com.needle.business;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Sadiq Ilu
 * This class describes the customer object
 *
 */
public class Guest {
	
	private StringProperty firstName = new SimpleStringProperty();
	private StringProperty lastName = new SimpleStringProperty();
	private StringProperty gender = new SimpleStringProperty();
	private LocalDate dob;
	private StringProperty phonenumber = new SimpleStringProperty();
	
	
	public Guest() {

	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName.getValue();
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName.setValue(firstName);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName.getValue();
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName.setValue(lastName);
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender.getValue();
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender.setValue(gender);
	}

	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber.getValue();
	}

	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber.setValue(phonenumber);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer  "+" firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", phonenumber=" + phonenumber + "]";
	}
	

}
