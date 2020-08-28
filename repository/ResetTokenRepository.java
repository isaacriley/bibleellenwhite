/**
 * 
 */
package com.biblewhiteapp.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biblewhiteapp.beans.ResetToken;

/**
 * @author riley
 *
 */
@Repository
@Transactional
public interface ResetTokenRepository extends JpaRepository<ResetToken, Long> {
	
	public ResetToken findByEmail(String email);
	public ResetToken findByToken(String token);
	
	@Modifying
	@Query(value="delete from ResetToken rt where rt.email = :email")
	public void deleteTokenByEmail(String email);
	
	@Modifying
	@Query(value="delete from ResetToken rt where rt.token = :token")
	public void deleteResetToken(String token);
	
	@Query(value="select r.expire from ResetToken r where r.token = :token")
	public Date getExpireTime(String token);

}
