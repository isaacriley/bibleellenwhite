/**
 * 
 */
package com.biblewhiteapp.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.biblewhiteapp.beans.Address;

/**
 * @author riley
 *
 */
@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {

	@Modifying
	@Query(value="update Address a set a.street= :street where a.id= :id")
	public void updateStreetAddress(Long id, String street);
	
	@Modifying
	@Query(value="update Address a set a.street2= :street2 where a.id= :id")
	public void updateStreetAddress2(Long id, String street2);
	
	@Modifying
	@Query(value="update Address a set a.state= :state where a.id= :id")
	public void updateState(Long id, String state);
	
	@Modifying
	@Query(value="update Address a set a.city= :city where a.id= :id")
	public void updateCity(Long id, String city);
	
	@Modifying
	@Query(value="update Address a set a.county= :county where a.id= :id")
	public void updateCounty(Long id, String county);
	
	@Modifying
	@Query(value="update Address a set a.zipcode= :zipcode where a.id= :id")
	public void updateZipcode(Long id, String zipcode);
	
	@Modifying
	@Query(value="update Address a set a.country= :country where a.id= :id")
	public void updateCountry(Long id, String country);
	
	@Query(value="select a from Address a where a.profileid= :profileid")
	public Optional<Address> getUserProfileAddress(Long profileid);
	
	@Modifying
	@Query(value="update Address a set a.profileid= :profileid where addressid= :addressid")
	public void updateProfileId(Long profileid, Long addressid);
	
	@Modifying
	@Query(value="delete from Address a where a.profileid= :profileid")
	public void deleteUserProfileAddress(Long profileid);
}
