/**
 * 
 */
package com.biblewhiteapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.biblewhiteapp.beans.User;

/**
 * DAO for the {@link User}
 * @author riley
 *
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value="SELECT u FROM User u "
			+ "where u.firstname= :firstname and u.lastname = :lastname")
	public List<User> getUserByFirstLastName(String firstname, String lastname);
	
	@Query(value="SELECT u FROM User u where u.email = :email")
	public User getUserByEmail(String email);
	
	@Modifying
	@Query(value="update User u set u.subscribed= :subscribed where u.email= :email")
	public void updateSubscribedStatus(String email, boolean subscribed);
	
	@Modifying
	@Query(value="update User u set u.unsubtoken= :unsubtoken where u.email= :email")
	public void setUnSubcribeToken(String email, String unsubtoken);
	
	@Query(value="select u from User u where u.unsubtoken= :unsubtoken")
	public User findBySubcribeToken(String unsubtoken);
	
}
