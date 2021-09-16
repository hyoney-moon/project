package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Board;

public interface mainBoardRepository extends JpaRepository<Board, Long> {

	public List<Board> findByboardNum(Long boardNum);
	
	public List<Board> findAll();
}
