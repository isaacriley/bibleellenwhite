/**
 * 
 */
package com.biblewhiteapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.biblewhiteapp.beans.Scripture;

/**
 * DAO for the Bible database
 * @author zac
 *
 */
@Transactional
public interface ScriptureRepository extends JpaRepository<Scripture, Long> {

	
	@Query(value="SELECT s FROM Scripture s where s.book= :book and s.chapter = :chapter and s.verse =:verse")
	public Scripture getScripture(String book, int chapter, int verse);
	
	
}
