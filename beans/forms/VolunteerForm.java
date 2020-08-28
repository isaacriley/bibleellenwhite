/**
 * 
 */
package com.biblewhiteapp.beans.forms;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Command object for the Volunteer form 
 * @author riley
 *
 */
public class VolunteerForm implements Serializable{
	
	private static final long serialVersionUID = -6480177287636680526L;

	@NotNull 
	@NotBlank(message = "Please enter your name")
	@Size(max=1000, message="The name has more than 500 characters")
	private String fullName;
	
	
	@Size(max=1000, message="The name has more than 1000 characters")
	private String church;
	@Email 
	@NotBlank(message = "We are unable to validate the email address you entered")
	@Size(max=1000, message="The email has more than 1000 characters")
	private String emailAddress;
	
	@NotNull
	private String helps;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getChurch() {
		return church;
	}

	public void setChurch(String church) {
		this.church = church;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getHelps() {
		return helps;
	}

	public void setHelps(String helps) {
		this.helps = helps;
	}

	@Override
	public String toString() {
		return "VolunteerForm [fullName=" + fullName + ", church=" + church + ", emailAddress=" + emailAddress
				+ ", helps=" + helps + "]";
	}

	
	
}
