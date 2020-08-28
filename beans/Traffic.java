/**
 * 
 */
package com.biblewhiteapp.beans;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Model bean for traffic access to the site
 * @author isaac
 *
 */
@Entity
@Table(name = "traffic")
public class Traffic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String sessionid;
	private String ipaddress;
	private String email;
	private String firstname;
	private String lastname;
	@NotNull
	private String role;
	@NotNull
	private Date createdon;
	private Date endedon;
	private Date expiredon;
	private boolean isexpired;
	private String city;
	private String state;
	private String zipcode;
	private String timezone;
	private String country;
	private String continent;
	private String isp;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the sessionid
	 */
	public String getSessionid() {
		return sessionid;
	}
	/**
	 * @param sessionid the sessionid to set
	 */
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	/**
	 * @return the ipaddress
	 */
	public String getIpaddress() {
		return ipaddress;
	}
	/**
	 * @param ipaddress the ipaddress to set
	 */
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}
	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the continent
	 */
	public String getContinent() {
		return continent;
	}
	/**
	 * @param continent the continent to set
	 */
	public void setContinent(String continent) {
		this.continent = continent;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the createdon
	 */
	public Date getCreatedon() {
		return createdon;
	}
	/**
	 * @param createdon the createdon to set
	 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	
	/**
	 * @return the expiredon
	 */
	public Date getExpiredon() {
		return expiredon;
	}
	/**
	 * @return the isp
	 */
	public String getIsp() {
		return isp;
	}
	/**
	 * @param isp the isp to set
	 */
	public void setIsp(String isp) {
		this.isp = isp;
	}
	/**
	 * @param expiredon the expiredon to set
	 */
	public void setExpiredon(Date expiredon) {
		this.expiredon = expiredon;
	}
	/**
	 * @return the isexpired
	 */
	public boolean isIsexpired() {
		return isexpired;
	}
	/**
	 * @param isexpired the isexpired to set
	 */
	public void setIsexpired(boolean isexpired) {
		this.isexpired = isexpired;
	}
	
	/**
	 * Set the expiration of the reset token (in minutes)
	 * @param minutes in how many minutes does this reset token expire?
	 */
	 public void setExpire(int minutes){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiredon = now.getTime();
    }

   public boolean isExpired() {
       return new Date().after(this.expiredon);
   }

	
	/**
	 * @return the endedon
	 */
	public Date getEndedon() {
		return endedon;
	}
	/**
	 * @param endedon the endedon to set
	 */
	public void setEndedon(Date endedon) {
		this.endedon = endedon;
	}
	@Override
	public String toString() {
		return "Traffic [id=" + id + ", sessionid=" + sessionid + ", ipaddress=" + ipaddress + ", email=" + email
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", role=" + role + ", createdon=" + createdon
				+ ", endedon=" + endedon + ", expiredon=" + expiredon + ", isexpired=" + isexpired + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", timezone=" + timezone + ", country=" + country
				+ ", continent=" + continent + ", isp=" + isp + "]";
	}
	
	
	
}
