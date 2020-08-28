/**
 * 
 */
package com.biblewhiteapp.beans;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model bean for images to be used in the app, especially for email responses
 * @author isaac
 *
 */
@Entity
@Table(name="images")
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String filename;
	private byte[] image;
	private String encodedstring;
	private Date createdon;
	private String purpose;
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
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	/**
	 * @return the encodedstring
	 */
	public String getEncodedstring() {
		return encodedstring;
	}
	/**
	 * @param encodedstring the encodedstring to set
	 */
	public void setEncodedstring(String encodedstring) {
		this.encodedstring = encodedstring;
	}
	/**
	 * @return the createdon
	 */
	public Date getCreatedon() {
		return createdon;
	}
	/**
	 * @param createdon the createdon to set
	 */
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	/**
	 * @return the purpose
	 */
	public String getPurpose() {
		return purpose;
	}
	/**
	 * @param purpose the purpose to set
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	@Override
	public String toString() {
		return "Images [id=" + id + ", filename=" + filename + ", image=" + Arrays.toString(image) + ", encodedstring="
				+ encodedstring + ", createdon=" + createdon + ", purpose=" + purpose + "]";
	}
	
		
}
