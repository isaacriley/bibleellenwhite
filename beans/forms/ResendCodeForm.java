/**
 * 
 */
package com.biblewhiteapp.beans.forms;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Form-backing bean for allowing us to resend a manual token for 2 step authentication
 * @author isaac
 *
 */
public class ResendCodeForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7533356728415062067L;
	
	@NotEmpty(message = "We need the email address")
	@Email
	private String email;

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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ResendCodeForm [email=" + email + "]";
	}
	
	

}
