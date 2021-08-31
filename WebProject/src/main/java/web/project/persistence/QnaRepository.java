package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Qna;

public interface QnaRepository extends JpaRepository<Qna, Long> {

}
