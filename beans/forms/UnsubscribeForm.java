/**
 * 
 */
package com.biblewhiteapp.beans.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Form backing bean for the Unsubscribe from daily email forms
 * @author riley
 *
 */
public class UnsubscribeForm {

	@Email 
	@NotEmpty
	@NotBlank(message = "We are unable to validate the email address you entered")
	@Size(max=2000, message="That email address has more than 2000 characters")
	private String email;

	private boolean cancel;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isCancel() {
		return cancel;
	}
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}
	@Override
	public String toString() {
		return "UnsubscribeForm [email=" + email + ", cancel=" + cancel + "]";
	}
	
		
}
