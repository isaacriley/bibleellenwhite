/**
 * 
 */
package com.biblewhiteapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.biblewhiteapp.beans.EllenWhiteReferences;

/**
 * Searches the DB for Ellen White based on bible texts selected
 * @author zac
 *
 */
@Transactional
//public interface EllenReferencesRepository extends JpaRepository<EllenWhiteReferences, Long>{
public interface EllenReferencesRepository extends PagingAndSortingRepository<EllenWhiteReferences, Long>{
	
	@Query(value="SELECT e FROM EllenWhiteReferences e "
			+ "where e.biblebook = :biblebook and "
			+ "e.biblechapter = :biblechapter  and e.bibleverse =:bibleverse")
	public  List<EllenWhiteReferences> getEllenWhiteReferencesForScriptureOld(
							@Param("biblebook")String biblebook,
							@Param("biblechapter")int biblechapter, 
							@Param("bibleverse")int bibleverse,
							Pageable pageable);
	
	@Query(value="SELECT e FROM EllenWhiteReferences e "
			+ "where e.biblebook = :biblebook and "
			+ "e.biblechapter = :biblechapter  and e.bibleverse =:bibleverse")
	public  List<EllenWhiteReferences> getEllenWhiteReferencesForScripture(String biblebook, 
				int biblechapter, int bibleverse);
	

	@Query(value="SELECT e FROM EllenWhiteReferences e "
			+ "where e.biblebook = :biblebook and "
			+ "e.biblechapter = :biblechapter  and e.bibleverse =:bibleverse "
			+ "order by e.bookname ASC")
	public  Page<EllenWhiteReferences> getEllenWhiteReferencesForBible(String biblebook, 
				int biblechapter, int bibleverse, Pageable pageable);
	
	@Query(value="select * from ellenreferences.bookreferences order by id desc limit 1", nativeQuery=true)
	public EllenWhiteReferences getLastRow();
	
	@Query(value=" select count(*) from ellenreferences.bookreferences", nativeQuery=true)
	public int getNumRecords();

	@Query(value="SELECT e FROM EllenWhiteReferences e "
			+ "where e.biblebook= :book and e.biblechapter= :chapter"
			+ "  and e.bibleverse= :verse order by e.id DESC")
	public Page<EllenWhiteReferences> sortByLatest(String book, int chapter, int verse, Pageable pageable);
	
	@Query(value="select ew from EllenWhiteReferences ew where ew.bookname= :book and ew.biblechapter= :chapter and "
			+ "ew.bibleverse= :verse order by ew.id asc ")
	public Page<EllenWhiteReferences> sortByNewest(String book, int chapter, int verse, Pageable pageable);
	
	@Query(value="select ew from EllenWhiteReferences ew where ew.bookname= :book and ew.biblechapter= :chapter and "
			+ "ew.bibleverse= :verse order by ew.bookname asc ")
	public Page<EllenWhiteReferences> sortAscendingBookCode(String book, int chapter, int verse, Pageable pageable);

	@Query(value="select ew from EllenWhiteReferences ew where ew.bookname= :book and ew.biblechapter= :chapter and "
			+ "ew.bibleverse= :verse order by ew.bookname desc ")
	public Page<EllenWhiteReferences> sortDescendingBookCode(String book, int chapter, int verse, Pageable pageable);

}
