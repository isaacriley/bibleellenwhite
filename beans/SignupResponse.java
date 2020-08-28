/**
 * 
 */
package com.biblewhiteapp.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity bean for the signup response email
 * @author riley
 *
 */
@Entity
public class SignupResponse {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String book;
	private int chapter;
	private int verse;
	private String quote;
	private String ref;
	private String page;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public int getChapter() {
		return chapter;
	}
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}
	public int getVerse() {
		return verse;
	}
	public void setVerse(int verse) {
		this.verse = verse;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	@Override
	public String toString() {
		return "SignupReponse [id=" + id + ", book=" + book + ", chapter=" + chapter + ", verse=" + verse + ", quote="
				+ quote + ", ref=" + ref + ", page=" + page + "]";
	}
		
}
