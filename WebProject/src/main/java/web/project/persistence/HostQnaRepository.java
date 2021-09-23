package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.HostQna;
//
public interface HostQnaRepository extends JpaRepository<HostQna, Long> {

	@Query("SELECT q from Board b, HostQna q WHERE b.boardNum = ?1 and q.board.boardNum = ?1 ")
	List<HostQna> getHostQnaList(Long boardNum);
}
