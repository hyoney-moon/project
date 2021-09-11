package web.project.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.Board;
//
public interface BoardRepository extends JpaRepository<Board, Long> {

	Page<Board> findByOrderByBoardNumDesc(Pageable page);

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
	
	
	
}
