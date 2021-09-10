package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	

}