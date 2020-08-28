/**
 * 
 */
package com.biblewhiteapp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

/**
 * Entity bean for the Roles table
 * @author riley
 *
 */
@EqualsAndHashCode
@Entity
@Table(name="roles")
public class Roles implements Serializable{

	private static final long serialVersionUID = 6365002148375835935L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String email;
	private String firstname;
	private String lastname;
	private String role;
	private String password;
	private Date dateadded;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the dateadded
	 */
	public Date getDateadded() {
		return dateadded;
	}
	/**
	 * @param dateadded the dateadded to set
	 */
	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", role=" + role + ", password=" + password + ", dateadded=" + dateadded + "]";
	}
	
}
