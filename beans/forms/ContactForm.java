/**
 * 
 */
package com.biblewhiteapp.beans.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Command object for the Contact Us form 
 * @author riley
 *
 */
public class ContactForm {
	
	@NotNull
	@Size(min=2, max=100, message="Name should be between 2 and 100 characters")
	private String fullName;
	
	@NotNull
	private String subject;
	@Email 
	@NotBlank(message = "We are unable to validate the email address you entered")
	@Size(max=200, message="That email address has more than 200 characters")
	private String emailAddress;
	
	@NotNull
	@NotBlank(message = "We cannot help you if you don't share your concerns with us")
	@Size(min=2, max=3000, message="This field has a 3000 character limit")
	private String concerns;
	
	/**
	 * @return the user's full name
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullname the user's full name to set
	 */
	public void setFullName(String fullname) {
		this.fullName = fullname;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
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
	/**
	 * @return the comments/concerns
	 */
	public String getConcerns() {
		return concerns;
	}
	/**
	 * @param concerns the concerns/comments to set
	 */
	public void setConcerns(String concerns) {
		this.concerns = concerns;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ContactForm [name=" + fullName + ",  emailAddress=" + emailAddress +"," 
				+"subject=" + subject + ","+ "\n" +"concerns="+ concerns + "]";
	}
	
	
}
