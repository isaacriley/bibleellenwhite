/**
 * 
 */
package com.biblewhiteapp.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean for addresses
 * @author riley
 *
 */
@Entity
@Table(name="address")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8247667631529393876L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long addressid;
	
	private String street;
	//international address support
	private String street2;
	private String city;
	//county, borough, village
	private String county;
	//state or province
	private String state;
	//postal or zipcode
	private String zipcode;
	private String country;
	private Long profileid;
	
	//hyped up constructor
	public Address(String street, String street2, String city, String county, String state, String zipcode, 
			String country) {
		this.street=street;
		this.street2 = street2;
		this.city= city;
		this.county= county;
		this.state=state;
		this.zipcode=zipcode;
		this.country=country;
		
	}
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Long getId() {
		return addressid;
	}

	public void setId(Long id) {
		this.addressid = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

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
	
	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public Long getProfileid() {
		return profileid;
	}

	public void setProfileid(Long profileid) {
		this.profileid = profileid;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", street=" + street + ", street2=" + street2 + ", city=" + city
				+ ", county=" + county + ", state=" + state + ", zipcode=" + zipcode + ", country=" + country
				+ ", profileid=" + profileid + "]";
	}
}
