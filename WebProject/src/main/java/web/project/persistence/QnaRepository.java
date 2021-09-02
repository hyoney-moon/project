package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.Qna;

public interface QnaRepository extends JpaRepository<Qna, Long> {

	@Query("SELECT q from Board b, Qna q WHERE b.boardNum = ?1")
	List<Qna> getQnaList(Long boardNum);

}
