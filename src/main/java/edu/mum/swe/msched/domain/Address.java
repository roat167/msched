package edu.mum.swe.msched.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String city;
	private String state;
	private int zip;
	private String address;
	
	public Address(String city, String state, int zip, String address) {		
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
