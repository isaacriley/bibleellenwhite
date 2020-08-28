/**
 * 
 */
package com.biblewhiteapp.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.biblewhiteapp.beans.Traffic;

/**
 * DAo for {@link Traffic} beans
 * @author isaac
 *
 */
@Transactional
public interface TrafficRepository extends PagingAndSortingRepository<Traffic, Long> {
	
	@Modifying
	@Query(value = " update Traffic t set t.email= :email where t.id=:id")
	public void updateEmail(String email, Long id);
	
	@Modifying
	@Query(value = " update Traffic t set t.firstname= :firstname where t.id=:id")
	public void updateFirstanme(String firstname, Long id);
	
	@Modifying
	@Query(value = " update Traffic t set t.lastname= :lastname where t.id=:id")
	public void updateLastanme(String lastname, Long id);
	
	@Modifying
	@Query(value = " update Traffic t set t.role= :role where t.id=:id")
	public void updateRole(String role, Long id);
	
	@Modifying
	@Query(value = " update Traffic t set t.endedon= :endedon where t.id=:id")
	public void updateEndedon(Date endedon, Long id);
	
	@Query(value = "select * from Traffic t where t.email= :email", nativeQuery= true)
	public Page<Traffic> getTrafficEntryByEmail(String email, Pageable pageable);

	@Query(value = "select * from Traffic t where t.role= :role order by createdon ASC ", nativeQuery= true)
	public Page<Traffic> sortRole(Pageable pageable, String role);

	@Query(value = "select * from Traffic  order by createdon DESC ", nativeQuery= true)
	public Page<Traffic> sortEarliest(Pageable pageable);
	
	@Query(value = "select * from Traffic  order by createdon ASC ", nativeQuery= true)
	public Page<Traffic> sortLatest(Pageable pageable);

	@Query(value = "select * from Traffic  t where t.email= :email order by createdon ASC ", nativeQuery= true)
	public List<Traffic> getTrafficListByEmail(String email);


	@Modifying
	@Query(value ="update Traffic t set t.expiredon= :expiredon where t.id= :id")
	public void updateExpiredon(Date expiredon, Long id);
	
	@Modifying
	@Query(value ="update Traffic t set t.endedon= :endedon where t.sessionid= :sid")
	public void updateEndedonBySessionId(Date endedon, String sid);

	@Modifying
	@Query(value ="update Traffic t set t.createdon= :createdon where t.id= :id")
	public void updateCreatedon(Date createdon, Long id);

	@Query(value ="select t from Traffic t where t.sessionid= :sid")
	public Optional<Traffic> getTrafficBySesisonId( String sid);

	@Modifying
	@Query(value ="update Traffic t set t.isexpired= :isexpired where t.id= :id")
	public void updateIsexpiredFlag(boolean isexpired, Long id);


	@Query(value ="select t from Traffic t where t.email= :email")
	public Optional<Traffic> getTrafficByEmail(String email);
	
}
