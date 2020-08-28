/**
 * 
 */
package com.biblewhiteapp.beans;

import org.springframework.cache.annotation.Cacheable;

/**
 * Bean for users that are authorized to access administrator functions; it will be cacheable
 * @author isaac
 *
 */
@Cacheable("authoriseduser")
public class AuthorizedUser {
	
	private String email;
	private String token;
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "AuthorizedUser [email=" + email + ", token=" + token + "]";
	}
	
	
}
