/**
 * 
 */
package com.biblewhiteapp.beans;

import java.util.Date;
import java.time.LocalDateTime;

import javax.annotation.Nullable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.biblewhiteapp.utils.LoggingPlusUtils;

/**
 * Domain object for the user that contacts us
 * @author riley
 *
 */
@Entity
@Table(name="contactus")
public class ContactUs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=2, max=50, message="Your name cannot be less than 2 characters")
	private String fullname;
	
	@NotNull
	private String email;
	
	private String subject;
	
	@NotNull
	@Size(min=4, max=3000, message=" We can't help you if you don't share your concerns with us")
	private String concerns;
	
	@NotNull
	private Date commentdate;
	
	private String resolvedby;
	private String resolution;
	private LocalDateTime resolveddate;
	private Date resolvedateshow;
	private boolean isresolved;
	@Nullable
	private boolean locked;
	
	
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
	 * @return the user's full name
	 */
	public String getFullName() {
		return fullname;
	}
	/**
	 * @param fullname the user's full name to set
	 */
	public void setName(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * @return the email address
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
	 * @return the concerns
	 */
	public String getConcerns() {
		return concerns;
	}
	/**
	 * @param concerns the concerns to set
	 */
	public void setConcerns(String concerns) {
		this.concerns = concerns;
	}
	/**
	 * @return the dateofcomments
	 */
	public Date getDateofcomments() {
		return commentdate;
	}
	/**
	 * @param dateofcomments the dateofcomments to set
	 */
	public void setDateofcomments(Date dateofcomments) {
		this.commentdate = dateofcomments;
	}
	
	public Date getCurrentSqlDate() {
		return LoggingPlusUtils.getNowDateTime();
		
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public Date getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	/**
	 * 
	 * @return the handle of the administrator that answers the concerns/comments
	 */
	public String getResolvedby() {
		return resolvedby;
	}
	public void setResolvedby(String resolvedby) {
		this.resolvedby = resolvedby;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public LocalDateTime getResolveddate() {
		return resolveddate;
	}
	public void setResolveddate(LocalDateTime resolveddate) {
		this.resolveddate = resolveddate;
	}
	public Date getResolvedateshow() {
		return resolvedateshow;
	}
	public void setResolvedateshow(Date resolvedateshow) {
		this.resolvedateshow = resolvedateshow;
	}
	public boolean isIsresolved() {
		return isresolved;
	}
	public void setIsresolved(boolean isresolved) {
		this.isresolved = isresolved;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	@Override
	public String toString() {
		return "ContactUs [id=" + id + ", fullname=" + fullname + ", email=" + email + ", subject=" + subject
				+ ", concerns=" + concerns + ", commentdate=" + commentdate + ", resolvedby=" + resolvedby
				+ ", resolution=" + resolution + ", resolveddate=" + resolveddate + ", resolvedateshow="
				+ resolvedateshow + ", isresolved=" + isresolved + ", locked=" + locked + "]";
	}
	
	
	
}
