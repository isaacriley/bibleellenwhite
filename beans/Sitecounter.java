/**
 * 
 */
package com.biblewhiteapp.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bean for my own site counter stats
 * @author isaac
 *
 */
@Entity
@Table(name = "sitecounter")
public class Sitecounter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date day;
	private Long count; //daily total
	private Long total;//overall total
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
	 * @return the day
	 */
	public Date getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(Date day) {
		this.day = day;
	}
	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}
	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Sitecounter [id=" + id + ", count=" + count + ", total=" + total + "]";
	}
	
	

}
