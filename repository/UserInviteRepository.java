/**
 * 
 */
package com.biblewhiteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.biblewhiteapp.beans.UserInvite;

/**
 * DAO for the User Invite table
 * @author riley
 *
 */
@Transactional
public interface UserInviteRepository extends JpaRepository<UserInvite, Long>{
	
	@Query(value="select ui from UserInvite ui where ui.email= :email")
	public UserInvite getInviteByEmail(String email);
	
	@Query(value="select ui from UserInvite ui where ui.token= :token")
	public UserInvite getInviteByToken(String token);
	
	@Modifying
	@Query(value="delete from UserInvite u where u.email= :email")
	public void deleteInviteEntry(String email);
	
	@Modifying
	@Query(value="update UserInvite ui set ui.sent= :sent where ui.email= :email")
	public void setSentFlag(String email, boolean sent);
}
