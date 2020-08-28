/**
 * 
 */
package com.biblewhiteapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

import javax.transaction.Transactional;

import com.biblewhiteapp.beans.Volunteer;

/**
 * DAO for volunteers
 * @author riley
 *
 */
@Transactional
public interface VolunteerRepository extends PagingAndSortingRepository<Volunteer, Long> {
	
	@Modifying
	@Query(value="update Volunteer v set v.isvolunteer= :volunteer where v.volunteerid= :id")
	public void updateHasVolunteered(boolean volunteer, Long id);
	
	@Modifying
	@Query(value="update Volunteer v set v.isvolunteer= :volunteer where v.emailaddress= :email")
	public void updateHasVolunteeredByEmail(boolean volunteer, String email);
	
	@Modifying
	@Query(value="update Volunteer v set v.isadmin= :isadmin where v.volunteerid= :id")
	public void updateIsAdmin(boolean isadmin, Long id);

	@Modifying
	@Query(value="update Volunteer v set v.isadmin= :isadmin where v.emailaddress= :email")
	public void updateIsAdminByEmail(boolean isadmin, String email);

	@Query(value="select * from Volunteer order by volunteerid desc", nativeQuery=true)
	public Page<Volunteer> findAll4Display(Pageable pageable);

	@Query(value="select v from Volunteer v where v.emailaddress= :email")
	public Optional<Volunteer> getVolunteerByEmail(String email); 
		
}
