package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Qna;

public interface QnaRepository extends JpaRepository<Qna, Long> {

	List<Qna> findByNum(Long num);

}
