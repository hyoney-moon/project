package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import web.project.domain.CustQna;
//
public interface QnaRepository extends JpaRepository<CustQna, Long> {


	@Query("SELECT q from Board b, CustQna q WHERE b.boardNum = ?1 and q.board.boardNum = ?1 ")
	List<CustQna> getQnaList(Long boardNum);
	
	@Transactional
	@Modifying
	@Query("UPDATE CustQna c SET c.hostContent = ?1 WHERE c.qnaNum = ?2")
	void updateCustQna(String hostContent, Long qnaNum);
	
}
