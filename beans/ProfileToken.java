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
import javax.validation.constraints.Size;

/**
 * Entity bean for reset tokens
 * @author riley
 *
 */
@Entity
@Table(name="resettoken")
public class ProfileToken {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@NotNull
	@Size(max=100)
	private String email;
	
	@NotNull
	private String token;
	
	@NotNull
	private Date expire;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}
	

	/**
	 * Set the expiration of the reset token (in minutes)
	 * @param minutes in how many minutes does this reset token expire?
	 */
	 public void setExpire(int minutes){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expire = now.getTime();
    }

   public boolean isExpired() {
       return new Date().after(this.expire);
   }

@Override
public String toString() {
	return "ResetToken [ID=" + ID + ", email=" + email + ", token=" + token + ", expire=" + expire + "]";
}

   
   
}
