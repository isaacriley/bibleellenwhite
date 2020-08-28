/**
 * 
 */
package com.biblewhiteapp.beans.forms;

/**
 * Form backing bean for printing references
 * @author riley
 *
 */
public class PrintReferenceForm {
	
	private String quoteName;
	private String quotePage;
	private String quote;
	
	public String getQuoteName() {
		return quoteName;
	}
	public void setQuoteName(String quoteName) {
		this.quoteName = quoteName;
	}
	public String getQuotePage() {
		return quotePage;
	}
	public void setQuotePage(String quotePage) {
		this.quotePage = quotePage;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	@Override
	public String toString() {
		return "PrintReferenceForm [quoteName=" + quoteName + ", quotePage=" + quotePage + ", quote=" + quote + "]";
	}
	

}
