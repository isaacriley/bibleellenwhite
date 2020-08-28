/**
 * 
 */
package com.biblewhiteapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.biblewhiteapp.beans.EmailDigest;


/**
 * DAO for email digests
 * @author riley
 *
 */
@Transactional
public interface EmailDigestRepository extends PagingAndSortingRepository<EmailDigest, Long>{
	
	@Query(value="select ed from EmailDigest ed where ed.sent= :sent")
	public List<EmailDigest> getFirstNonSentRecord(boolean sent);
	
	@Modifying
	@Query(value="update EmailDigest em set em.sent= :sent where em.id= :id")
	public void updateSentFlag(Long id, boolean sent);
	
	@Modifying
	@Query(value="update EmailDigest em set em.datesent= :dsent where em.id= :id")
	public void updateDateSent(Long id, Date dsent);
	
	@Modifying
	@Query(value="update EmailDigest em set em.dateresent= :rsent where em.id= :id")
	public void updateDateResent(Long id, Date rsent);

	@Query(value="select * from EmailDigest top 1", nativeQuery= true )
	public EmailDigest getFirstRecord();

	@Query(value="select em from EmailDigest em order by datecreated DESC")
	public Page<EmailDigest> sortUnresolvedLatest(Pageable pageable);

	@Query(value="select em from EmailDigest em order by datecreated ASC")
	public Page<EmailDigest> sortUnresolvedEarliest(Pageable pageable);

	@Modifying
	@Query(value="update EmailDigest em set em.readytorun= :readytorun where em.id= :id")
	public void updateReadyToRun(Long id, boolean readytorun);

}
