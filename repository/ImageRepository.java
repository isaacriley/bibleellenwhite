/**
 * 
 */
package com.biblewhiteapp.repository;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.biblewhiteapp.beans.Images;

/**
 * DAO for {@link Images}
 * @author isaac
 *
 */
@Transactional
public interface ImageRepository extends JpaRepository<Images, Long> {
	
	@Modifying
	@Query(value="update Images i set i.filename= :filename where i.id= :id")
	public void updateFilename(String filename, Long id);
	
	@Modifying
	@Query(value="update Images i set i.image= :image where i.id= :id")
	public void updateImage(byte[] image, Long id);
	
	@Modifying
	@Query(value="update Images i set i.encodedstring= :encodestring where i.id= :id")
	public void updateEncodedString(String encodestring, Long id);
	
	@Modifying
	@Query(value="update Images i set i.createdon= :createdon where i.id= :id")
	public void updateCreatedOn(Date createdon, Long id);
	
	@Modifying
	@Query(value="update Images i set i.purpose= :purpose where i.id= :id")
	public void updatePurpose(String purpose, Long id);
	
	@Query(value="select i from Images i where i.purpose= :purpose")
	public Optional<Images> getImageByPurpose(String purpose);
	
	@Query(value="select i from Images i where i.filename= :filename")
	public Optional<Images> getImageByFilename(String filenam);
	
	@Query(value="select i.image from Images i where i.purpose= :purpose")
	public byte[] getImageBytesByPurpose(String purpose);
	
	@Query(value="select i.image from Images i where i.filename= :filename")
	public byte[] getImageBytesByFilename(String filename);

	@Query(value="select i.filename from Images i where i.purpose= :purpose")
	public String getFilenameForPurpose(String purpose);
	
	
}
