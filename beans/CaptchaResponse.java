package com.biblewhiteapp.beans;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model bean for aiding responses from Captcha 2
 * @author isaac
 *
 */
public class CaptchaResponse {

	private Boolean success;
    private Date timestamp;
    private String hostname;
    @JsonProperty("error-codes")
    private List<String> errorCodes;
	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}
	/**
	 * @param hostname the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	/**
	 * @return the errorCodes
	 */
	public List<String> getErrorCodes() {
		return errorCodes;
	}
	/**
	 * @param errorCodes the errorCodes to set
	 */
	public void setErrorCodes(List<String> errorCodes) {
		this.errorCodes = errorCodes;
	}
	@Override
	public String toString() {
		return "CaptchaResponse [success=" + success + ", hostname=" + hostname + ", errorCodes=" + errorCodes + "]";
	}
	
    
    
}
