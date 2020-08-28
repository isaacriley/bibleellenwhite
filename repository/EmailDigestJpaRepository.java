/**
 * 
 */
package com.biblewhiteapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblewhiteapp.beans.EmailDigest;

/**
 * JPA version of DAO for {@link EmailDigest}
 * @author isaac
 *
 */
@Transactional
public interface EmailDigestJpaRepository extends JpaRepository<EmailDigest, Long> {

}
