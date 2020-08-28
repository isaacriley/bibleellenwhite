/**
 * 
 */
package com.biblewhiteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblewhiteapp.beans.SignupResponse;

/**
 * DAO for the Signup Response table
 * @author riley
 *
 */
public interface SignupResponseRepository extends JpaRepository<SignupResponse, Long>{

}
