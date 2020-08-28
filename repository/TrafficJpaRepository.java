/**
 * 
 */
package com.biblewhiteapp.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.biblewhiteapp.beans.Traffic;

/**
 * Alternate DAo for Traffic beans
 * @author isaac
 *
 */
@Transactional
public interface TrafficJpaRepository extends JpaRepository<Traffic, Long> {
	
	@Modifying
	@Query(value="update Traffic t set t.isexpired= :isexpired where t.id= :id")
	public void updateIsexpired(boolean isexpired, Long id);
	
	@Modifying
	@Query(value="update Traffic t set t.expiredon= :expiredon where t.id= :id")
	public void updateExpiredon(Date expiredon, Long id);
	
	
	

}
