/**
 * 
 */
package com.biblewhiteapp.beans.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Form backing bean for the search for references (on home and/or references page)
 * @author riley
 *
 */
public class ReferenceSearchForm {
	
	@Size(min=3)
	private String bookName;
	@Min(1)
	private int chapter;
	private int verse;
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the chapter
	 */
	public int getChapter() {
		return chapter;
	}
	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	/**
	 * @return the verse
	 */
	public int getVerse() {
		return verse;
	}
	/**
	 * @param verse the verse to set
	 */
	public void setVerse(int verse) {
		this.verse = verse;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReferenceSearchForm [bookName=" + bookName + ", chapter=" + chapter + ", verse=" + verse + "]";
	}
	
}
