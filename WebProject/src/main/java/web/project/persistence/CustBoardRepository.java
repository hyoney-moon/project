package web.project.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import web.project.domain.Board;
//
public interface CustBoardRepository extends JpaRepository<Board, Long> {

	Page<Board> findByOrderByBoardNumDesc(Pageable page);
	
	//검색기능
	Page<Board> findBySpaceNameContainingIgnoreCase(String spaceName, Pageable page);
	Page<Board> findByCategoryContainingIgnoreCase(String category, Pageable page);
	Page<Board> findByAddressContainingIgnoreCase(String address, Pageable page);
	Page<Board> findBySpaceNameOrCategoryOrAddressContainingIgnoreCase(String spaceName,String category,String address, Pageable page );

	Board findByBoardNum(Long boardNum);
	
	@Transactional
	@Modifying
	@Query("UPDATE Board b SET b.readcount = b.readcount+1 WHERE b.boardNum=?1")
	int updateReadcount(Long boardNum);
}
