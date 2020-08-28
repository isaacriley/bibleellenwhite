/**
 * 
 */
package com.biblewhiteapp.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.biblewhiteapp.beans.Econsole;


/**
 * DAO for the admin's error console
 * @author isaac
 *
 */
@Transactional
public interface EconsoleRepository extends PagingAndSortingRepository<Econsole, Long> {
	
	@Modifying
	@Query(value="update Econsole ec set ec.isresolved= :isresolved where ec.id= :id")
	public void updateIsRsolved(boolean isresolved, Long id);

	@Modifying
	@Query(value="update Econsole ec set ec.resolveddate= :resolveddate where ec.id= :id")
	public void updateResolvedDate(Date resolveddate, Long id);
	
	/* Sorting */
	@Query(value = "select * from Econsole order by errorname ASC", nativeQuery = true)
	public Page<Econsole> sortByName(Pageable pageable);
	
	@Query(value = "select * from Econsole order by errordate DESC", nativeQuery = true)
	public Page<Econsole> sortByLatest(Pageable pageable);
	
	@Query(value = "select * from Econsole order by errordate ASC", nativeQuery = true)
	public Page<Econsole> sortByEarliest(Pageable pageable);
	
	@Query(value = "select * from Econsole where isresolved = true order by resolveddate DESC",
				nativeQuery = true)
	public Page<Econsole> showResolved(Pageable pageable);
	
	@Query(value = "select * from Econsole where isresolved = false order by errordate DESC", 
				nativeQuery = true)
	public Page<Econsole> showUnresolved(Pageable pageable);
	
	@Query(value = "select * from Econsole order by errordate ASC",nativeQuery = true)
	public Page<Econsole> showAll(Pageable pageable);
	
	@Query(value="select * from Econsole", nativeQuery= true)
	public List<Econsole> getAll();
	
}
