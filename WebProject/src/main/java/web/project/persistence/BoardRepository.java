package web.project.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Board;
import web.project.domain.BoardDto;
//
public interface BoardRepository extends JpaRepository<Board, Long> {

	Page<Board> findByOrderByBoardNumDesc(Pageable page);
	

}
