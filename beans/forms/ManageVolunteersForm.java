/**
 * 
 */
package com.biblewhiteapp.beans.forms;

import java.io.Serializable;

/**
 * Form backing bean for working with volunteers
 * @author riley
 *
 */
public class ManageVolunteersForm implements Serializable{

	private static final long serialVersionUID = -503617755289843196L;
	
	private int id;
	private String fullname;
	private String email;
	private String church;
	private String helps;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "ManageVolunteersForm [id=" + id + ", fullname=" + fullname + ", email=" + email + ", church=" + church
				+ ", helps=" + helps + "]";
	}
	
	
}
