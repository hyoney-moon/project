package web.project.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import web.project.domain.Board;
import web.project.domain.BoardDto;
import web.project.domain.PreBoard;

public interface BoardDtoRepository extends JpaRepository<Board, Integer> {

	Board findByBoardNum(Long boardNum);
	
	List<Board> findAll();
	
	Page<PreBoard> findByOrderByBoardNumDesc(Pageable page);
	
	@Transactional
	@Modifying
	@Query("UPDATE PreBoard b SET b.readcount = b.readcount+1 WHERE b.boardNum=?1")
	int updateReadcount(Long boardNum);
}
