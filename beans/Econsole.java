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
 * Model bean for the admin error console 
 * @author isaac
 *
 */

@EqualsAndHashCode
@Entity
@Table(name = "econsole")
public class Econsole implements Serializable{

	private static final long serialVersionUID = 8925453039743192540L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String errorname;
	private String filename;
	private String description;
	private String stacktrace;
	private Date errordate;
	private Date resolveddate;
	private boolean isresolved;
	private Integer errorcode;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the errorname
	 */
	public String getErrorname() {
		return errorname;
	}
	/**
	 * @param errorname the errorname to set
	 */
	public void setErrorname(String errorname) {
		this.errorname = errorname;
	}
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the stacktrace
	 */
	public String getStacktrace() {
		return stacktrace;
	}
	/**
	 * @param stacktrace the stacktrace to set
	 */
	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}
	/**
	 * @return the errordate
	 */
	public Date getErrordate() {
		return errordate;
	}
	/**
	 * @param errordate the errordate to set
	 */
	public void setErrordate(Date errordate) {
		this.errordate = errordate;
	}
	/**
	 * @return the resolveddate
	 */
	public Date getResolveddate() {
		return resolveddate;
	}
	/**
	 * @param resolveddate the resolveddate to set
	 */
	public void setResolveddate(Date resolveddate) {
		this.resolveddate = resolveddate;
	}
	/**
	 * @return the isresolved
	 */
	public boolean isIsresolved() {
		return isresolved;
	}
	/**
	 * @param isresolved the isresolved to set
	 */
	public void setIsresolved(boolean isresolved) {
		this.isresolved = isresolved;
	}
	/**
	 * @return the errorcode
	 */
	public Integer getErrorcode() {
		return errorcode;
	}
	/**
	 * @param errorcode the errorcode to set
	 */
	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Econsole [id=" + id + ", errorname=" + errorname + ", filename=" + filename + ", description="
				+ description + ", stacktrace=" + stacktrace + ", errordate=" + errordate + ", resolveddate="
				+ resolveddate + ", isresolved=" + isresolved + ", errorcode=" + errorcode + "]";
	}
	
	
}
