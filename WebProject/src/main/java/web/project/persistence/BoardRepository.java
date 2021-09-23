package web.project.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import web.project.domain.Board;
//
public interface BoardRepository extends JpaRepository<Board, Long> {

	Page<Board> findByOrderByBoardNumDesc(Pageable page);
	Page<Board> findBySpaceNameContainingIgnoreCase(String spaceName, Pageable page);
	Page<Board> findByCategoryContainingIgnoreCase(String category, Pageable page);
	Page<Board> findByAddressContainingIgnoreCase(String address, Pageable page);
	Page<Board> findBySpaceNameOrCategoryOrAddressContainingIgnoreCase(String spaceName,String category,String address, Pageable page );

	@Query(value="select count(*) from board where reg_Date < '2021-02-01'", nativeQuery=true)
	long boardCountJan();
	
	@Query(value="select count(*) from board where reg_Date < '2021-03-01'", nativeQuery=true)
	long boardCountFeb();
	
	@Query(value="select count(*) from board where reg_Date < '2021-04-01'", nativeQuery=true)
	long boardCountMar();
	
	@Query(value="select count(*) from board where reg_Date < '2021-05-01'", nativeQuery=true)
	long boardCountApr();
	
	@Query(value="select count(*) from board where reg_Date < '2021-06-01'", nativeQuery=true)
	long boardCountMay();
	
	@Query(value="select count(*) from board where reg_Date < '2021-07-01'", nativeQuery=true)
	long boardCountJun();
	
	@Query(value="select count(*) from board where reg_Date < '2021-08-01'", nativeQuery=true)
	long boardCountJul();
	
	@Query(value="select count(*) from board where reg_Date < '2021-09-01'", nativeQuery=true)
	long boardCountAug();
	
	@Query(value="select count(*) from board where reg_Date < '2021-10-01'", nativeQuery=true)
	long boardCountSep();
	
	Board findByBoardNum(Long boardNum);
	
	@Transactional
	@Modifying
	@Query("UPDATE Board b SET b.readcount = b.readcount+1 WHERE b.boardNum=?1")
	int updateReadcount(Long boardNum);
}
