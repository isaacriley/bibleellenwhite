/**
 * 
 */
package com.biblewhiteapp.beans.forms;

/**
 * Form backing bean for addresses in the user profile
 * @author riley
 *
 */
public class AddressForm {
	
	private String street;
	private String street2;
	private String city;
	private String county;
	private String state;
	private String zipcode;
	private String country;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "AddressForm [street=" + street + ", street2=" + street2 + ", city=" + city + ", county=" + county
				+ ", state=" + state + ", zipcode=" + zipcode + ", country=" + country + "]";
	}

}
