/**
 * 
 */
package com.biblewhiteapp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean for daily email digests
 * @author riley
 *
 */
@Entity
@Table(name="email_digest")
public class EmailDigest implements Serializable {
	
	private static final long serialVersionUID = 7293777610198599976L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String biblebook;
	private int biblechapter;
	private int bibleverse;
	private String quote;
	private String quotebook;
	private String quotepage;
	private boolean sent;
	private Date datesent;
	private Date datecreated;
	private String bibletext;
	private Date dateresent;
	private Boolean readytorun;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBiblebook() {
		return biblebook;
	}
	public void setBiblebook(String biblebook) {
		this.biblebook = biblebook;
	}
	public int getBiblechapter() {
		return biblechapter;
	}
	public void setBiblechapter(int biblechapter) {
		this.biblechapter = biblechapter;
	}
	public int getBibleverse() {
		return bibleverse;
	}
	public void setBibleverse(int bibleverse) {
		this.bibleverse = bibleverse;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getQuotebook() {
		return quotebook;
	}
	public void setQuotebook(String quotebook) {
		this.quotebook = quotebook;
	}
	public String getQuotepage() {
		return quotepage;
	}
	public void setQuotepage(String quotepage) {
		this.quotepage = quotepage;
	}
	public boolean isSent() {
		return sent;
	}
	public void setSent(boolean sent) {
		this.sent = sent;
	}
	
	/**
	 * @return the datesent
	 */
	public Date getDatesent() {
		return datesent;
	}
	/**
	 * @param datesent the datesent to set
	 */
	public void setDatesent(Date datesent) {
		this.datesent = datesent;
	}
	/**
	 * @return the dateresent
	 */
	public Date getDateresent() {
		return dateresent;
	}
	/**
	 * @param dateresent the dateresent to set
	 */
	public void setDateresent(Date dateresent) {
		this.dateresent = dateresent;
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
	 * @return the datecreated
	 */
	public Date getDatecreated() {
		return datecreated;
	}
	/**
	 * @param datecreated the datecreated to set
	 */
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	/**
	 * @return the readytorun
	 */
	public Boolean getReadytorun() {
		return readytorun;
	}
	/**
	 * @param readytorun the readytorun to set
	 */
	public void setReadytorun(Boolean readytorun) {
		this.readytorun = readytorun;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "EmailDigest [id=" + id + ", biblebook=" + biblebook + ", biblechapter=" + biblechapter + ", bibleverse="
				+ bibleverse + ", quote=" + quote + ", quotebook=" + quotebook + ", quotepage=" + quotepage + ", sent="
				+ sent + ", datesent=" + datesent + ", datecreated=" + datecreated + ", bibletext=" + bibletext
				+ ", dateresent=" + dateresent + ", readytorun=" + readytorun + "]";
	}
		
}
