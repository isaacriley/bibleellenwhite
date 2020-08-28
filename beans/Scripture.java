/**
 * 
 */
package com.biblewhiteapp.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * POJO for Scriptures
 * @author zac
 *
 */

@Entity
@Table(name="scripture")
public class Scripture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String book;
	
	@NotNull
	@Size(min = 1, max = 150)
	private int chapter;
	
	@NotNull
	@Size(min = 0, max = 176)
	private int verse;

	private String bibletext;
	
	public Scripture() {}

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

	/**
	 * @return the bible text (ex. "For God so loved..."
	 */
	public String getBibletext() {
		return bibletext;
	}

	/**
	 * @param text the bible text to set
	 */
	public void setBibletext(String text) {
		this.bibletext = text;
	}

	/**
	 * @return the book
	 */
	public String getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(String book) {
		this.book = book;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Scripture [id=" + id + ", book=" + book + ", chapter=" + chapter + ", "
				+ "verse=" + verse + ", bibletext="+ bibletext + "]";
	}

	

	
}
