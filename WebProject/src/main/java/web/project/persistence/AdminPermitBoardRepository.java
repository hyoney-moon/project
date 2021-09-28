package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import web.project.domain.Board;

public interface AdminPermitBoardRepository extends JpaRepository<Board, Long> {

	@Query(value="SELECT * FROM board WHERE permit = 0", nativeQuery=true)
	List<Board> permitBoardList();
	
	@Transactional
	@Modifying
	@Query("UPDATE Board b SET b.permit = 1 WHERE b.boardNum = ?1")
	void permitBoard(Long boardNum);
	
	@Transactional
	@Modifying
	@Query("UPDATE Board b SET b.permit = 2 WHERE b.boardNum = ?1")
	void rejectPermitBoard(Long boardNum);
} 
