package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.Board;

public interface PermitBoardRepository extends JpaRepository<Board, Long> {

	@Query(value="SELECT * FROM board WHERE permit = 0", nativeQuery=true)
	List<Board> permitBoardList();
}
