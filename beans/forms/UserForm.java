/**
 * 
 */
package com.biblewhiteapp.beans.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * Bean that backs the new user signup form
 * @author riley
 *
 */
@Component
public class UserForm {

	@NotNull
	@Size(min=2, max=100, message="Your first name cannot be more than 100 characters")	
	private String firstName;
	@Size(min=2, max=100, message="Your last name cannot be more than 100 characters")
	private String lastName;
	@Email
	@NotEmpty(message="This does not appear to be a valid email address")
	@Size(max=200, message="Your email address cannot be more than 200 characters")
	private String emailAddress;
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserForm [firstName=" + firstName + ", lastName=" + lastName + ","
				+ " emailAddress=" + emailAddress + "]";
	}
			
	
}
