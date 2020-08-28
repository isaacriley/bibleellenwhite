/**
 * 
 */
package com.biblewhiteapp.beans.forms;

import java.io.Serializable;

/**
 * Form backing bean for sorting errors
 * @author riley
 *
 */
public class SortErrorsForm implements Serializable {
	

	private static final long serialVersionUID = -1410192194425739364L;
	private String sortit;
	/**
	 * @return the sortit
	 */
	public String getSortit() {
		return sortit;
	}
	/**
	 * @param sortit the sortit to set
	 */
	public void setSortit(String sortit) {
		this.sortit = sortit;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SortErrorsForm [sortit=" + sortit + "]";
	}

}
