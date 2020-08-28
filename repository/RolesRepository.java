/**
 * 
 */
package com.biblewhiteapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.biblewhiteapp.beans.Roles;

/**
 * DAO for the Roles tab
 * @author riley
 *
 */
@Transactional
public interface RolesRepository extends JpaRepository<Roles, Long>{
	
	@Modifying
	@Query(value="update Roles r set r.role= :role where r.email= :email")
	public void updateRole(String role, String email);

	@Query(value="select r from Roles r where r.email= :username")
	public Roles findByEmail(String username);
	
	@Modifying
	@Query(value="update Roles r set r.password= :password where r.id= :id")
	public void updatePassword(String password, Long id);

}
