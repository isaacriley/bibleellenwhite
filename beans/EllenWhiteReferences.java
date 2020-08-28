/**
 * 
 */
package com.biblewhiteapp.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Representation of the indices that in Ellen White's writings that are
 * commentaries on various Bible texts
 * @author zac
 *
 */
@Entity
@Table(name="bookreferences")
public class EllenWhiteReferences implements Serializable{
	
	private static final long serialVersionUID = -3260930069446131740L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String bookcode;
	@NotNull
	private String bookname;
	@NotNull
	private String pages;
	@NotNull
	private String quote;
	private String chapter;
	private String section;
	private String paragraph;
	@NotNull
	private String biblebook;
	@NotNull
	private int biblechapter;
	@NotNull
	private int bibleverse;
	private String bibletext;

	public EllenWhiteReferences() {}
	
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
	 * @return the  (ex. DA, for The Desire of The Ages)
	 */
	public String getBookcode() {
		return bookcode;
	}
	/**
	 * @param bookcode the bookcode to set
	 */
	public void setBookcode(String bookcode) {
		this.bookcode = bookcode;
	}
	/**
	 * @return the bookname (Ex. The Desire of The Ages
	 */
	public String getBookname() {
		return bookname;
	}
	/**
	 * @param bookname the bookname to set
	 */
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	/**
	 * @return the pages in the Ellen White reference that covers the Bible text
	 */
	public String getPages() {
		return pages;
	}
	/**
	 * @param pages the pages to set
	 */
	public void setPages(String pages) {
		this.pages = pages;
	}
	/**
	 * @return the quote, what the actual quoted reference says (on the Bible text)
	 */
	public String getQuote() {
		return quote;
	}
	
	/* Ok, technically it may no longer be a bean*/
	private String sanitize(String quotes) {
		String para="\t";
		String rep = quotes.replace("\\", "");
		return para+rep;
		
	}
	
	/**
	 * @param quote the quote to set
	 */
	public void setQuote(String quote) {
		
		this.quote = sanitize(quote);
	}
	
	/**
	 * @return the chapter
	 */
	public String getChapter() {
		return chapter;
	}
	/**
	 * @param chapter the chapter to set
	 */
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}
	/**
	 * @param section the section to set
	 */
	public void setSection(String section) {
		this.section = section;
	}
	/**
	 * @return the paragraph
	 */
	public String getParagraph() {
		return paragraph;
	}
	/**
	 * @param paragraph the paragraph to set
	 */
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}
	/**
	 * @return the bibletext
	 */
	public String getBibletext() {
		return bibletext;
	}

	/**
	 * @param bibletext the bibletext to set
	 */
	public void setBibletext(String bibletext) {
		this.bibletext = bibletext;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the biblebook
	 */
	public String getBiblebook() {
		return biblebook;
	}
	/**
	 * @param biblebook the biblebook to set
	 */
	public void setBiblebook(String biblebook) {
		this.biblebook = biblebook;
	}
	/**
	 * @return the biblechapter
	 */
	public int getBiblechapter() {
		return biblechapter;
	}
	/**
	 * @param biblechapter the biblechapter to set
	 */
	public void setBiblechapter(int biblechapter) {
		this.biblechapter = biblechapter;
	}
	/**
	 * @return the bibleverse
	 */
	public int getBibleverse() {
		return bibleverse;
	}
	/**
	 * @param bibleverse the bibleverse to set
	 */
	public void setBibleverse(int bibleverse) {
		this.bibleverse = bibleverse;
	}

	@Override
	public String toString() {
		return "EllenWhiteReferences [id=" + id + ", bookcode=" + bookcode + ", bookname=" + bookname + ", pages="
				+ pages + ", quote=" + quote + ", chapter=" + chapter + ", section=" + section + ", paragraph="
				+ paragraph + ", biblebook=" + biblebook + ", biblechapter=" + biblechapter + ", bibleverse="
				+ bibleverse + ", bibletext=" + bibletext + "]";
	}
	
	

}
