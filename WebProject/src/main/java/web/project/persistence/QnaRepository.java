package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.CustQna;
import web.project.domain.HostQna;
//
public interface QnaRepository extends JpaRepository<CustQna, Long> {


	@Query("SELECT q from Board b, CustQna q WHERE b.boardNum = ?1 and q.board.boardNum = ?1 ")
	List<CustQna> getQnaList(Long boardNum);


}
