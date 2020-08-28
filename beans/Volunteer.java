/**
 * 
 */
package com.biblewhiteapp.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model bean for Volunteers
 * @author riley
 *
 */
@Entity
@Table(name="volunteer")
public class Volunteer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long volunteerid;
	private String fullname;
	private String emailaddress;
	private String church;
	private String helps;
	private Date volunteerdate;
	private boolean isvolunteer;
	private boolean isadmin;
	
	
	public Long getVolunteerid() {
		return volunteerid;
	}
	public void setVolunteerid(Long volunteerid) {
		this.volunteerid = volunteerid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getChurch() {
		return church;
	}
	public void setChurch(String church) {
		this.church = church;
	}
	public String getHelps() {
		return helps;
	}
	public void setHelps(String helps) {
		this.helps = helps;
	}
	public Date getVolunteerdate() {
		return volunteerdate;
	}
	public void setVolunteerdate(Date volunteerdate) {
		this.volunteerdate = volunteerdate;
	}
	
	public boolean isVolunteered() {
		return isvolunteer;
	}
	public void setIsvolunteered(boolean isvolunteer) {
		this.isvolunteer = isvolunteer;
	}
	
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	
	@Override
	public String toString() {
		return "Volunteer [volunteerid=" + volunteerid + ", fullname=" + fullname + ", emailaddress=" + emailaddress
				+ ", church=" + church + ", helps=" + helps + ", volunteerdate=" + volunteerdate + ", hasvolunteered="
				+ isvolunteer + ", isadmin=" + isadmin + "]";
	}
	
	
}
