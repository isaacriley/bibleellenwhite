/**
 * 
 */
package com.biblewhiteapp.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biblewhiteapp.beans.ContactUs;

/**
 * @author riley
 *
 */
@Transactional
@Repository
public interface ContactRepository extends PagingAndSortingRepository<ContactUs, Long>{
	
	@Query(value="SELECT cu from ContactUs cu where cu.email = :email")
	public ContactUs getContactUserByEmail(@Param("email")String email);
	
	@Query(value="select * from ContactUs cu where cu.email= :email "
			+ "order by commentdate DESC", nativeQuery=true)
	public List<ContactUs> getContactsThreadByEmail(String email);
	
	@Query(value="SELECT cu.concerns from ContactUs cu where cu.email = :email")
	public String getCommentsByEmail(@Param("email") String email);

	@Modifying
	@Query(value="update ContactUs cu set cu.resolvedby= :resolver where cu.email= :email")
	public void updateResolvedStatusByEmail(String email, String resolver);
	
	@Modifying
	@Query(value="update ContactUs cu set cu.resolvedby= :resolver where cu.id= :id")
	public void updateResolvedStatusById(Long id, String resolver);
	
	@Modifying
	@Query(value="delete from ContactUs cu where cu.id= :id")
	public void deleteContactUserById(Long id);
	
	@Modifying
	@Query(value="delete from ContactUs cu where cu.email= :email")
	public void deleteContactUserByEmail(String email);
	
	@Query(value="select cu from ContactUs cu where cu.isresolved= :isResolved")
	public List<ContactUs> findAllUnresolved(boolean  isResolved);
	
	@Query(value="select * from ContactUs cu "
			+ "where cu.isresolved= :isResolved limit 5", nativeQuery = true)
	public List<ContactUs> findLatest5Unresolved(boolean  isResolved);
	
	@Query(value="select cu from ContactUs cu where cu.isresolved= :isResolved")
	public Page<ContactUs> getUnresolvedDashboard(boolean isResolved, Pageable pageable);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select cu from ContactUs cu where cu.isresolved= :isResolved")
	public Page<ContactUs> getAllUnresolved(boolean isResolved, Pageable pageable);
	
	@Query(value="select cu from ContactUs cu where cu.locked= :locked")
	public List<ContactUs>getLocked(boolean locked);

	@Modifying
	@Query(value="update ContactUs cu set cu.resolution= :resolution, cu.resolveddate= :resolvedDate,"
			+ "cu.resolvedateshow= :rdate, cu.resolvedby= :resolvedBy, cu.isresolved= :isResolved where cu.id= :id")
	public void resolveRow(Long id, String resolution, LocalDateTime resolvedDate, Date rdate, String resolvedBy,
			boolean isResolved);
	
	@Query(value=" select c.resolvedby from ContactUs c where c.id= :id")
	public String getResolvedByConcernId(Long id);
	
	@Query(value="select * from ContactUs cu where cu.isresolved= :isresolved", nativeQuery=true)
	public Page<ContactUs> sortAllByUnresolved(Pageable pageable, boolean isresolved);
	
	@Query(value="select * from ContactUs cu where cu.isresolved= :isresolved", nativeQuery=true)
	public Page<ContactUs> showResolved(Pageable pageable, boolean isresolved);

	@Query(value="select * from ContactUs cu where cu.isresolved= :isresolved order by commentdate DESC", nativeQuery=true)
	public Page<ContactUs> sortUnresolvedLatest(Pageable pageable,  boolean isresolved);
	
	@Query(value="select * from ContactUs cu where cu.isresolved= :b order by commentdate ASC", nativeQuery=true)
	public Page<ContactUs> sortUnresolvedEarliest(Pageable pageable, boolean b);

	@Query(value="select * from ContactUs cu where cu.isresolved= :isresolved order by subject ASC", nativeQuery=true)
	public Page<ContactUs> sortBySubject(Pageable pageable,  boolean isresolved);


	@Query(value="select * from ContactUs cu where cu.isresolved= :isresolved order by fullname ASC", nativeQuery=true)
	public Page<ContactUs> sortByName(Pageable pageable,  boolean isresolved);

	@Query(value="select * from ContactUs cu where cu.isresolved= :isresolved order by email ASC", nativeQuery=true)
	public Page<ContactUs> sortByEmail(Pageable pageable,  boolean isresolved);
}
