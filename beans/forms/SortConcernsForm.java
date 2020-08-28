/**
 * 
 */
package com.biblewhiteapp.beans.forms;

import java.io.Serializable;

/**
 * Form backing bean for sorting the "contact us" list
 * @author riley
 *
 */
public class SortConcernsForm implements Serializable{
	
	private static final long serialVersionUID = -5288043820623554825L;
	private String sortit;

	public String getSortit() {
		return sortit;
	}

	public void setSortit(String sortit) {
		this.sortit = sortit;
	}

	@Override
	public String toString() {
		return "SortSuppliersForm [sortit=" + sortit + "]";
	}
	

}
