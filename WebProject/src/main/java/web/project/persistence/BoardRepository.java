package web.project.persistence;

import java.util.List; 

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	Page<Board> findByOrderByNumDesc(Pageable page);
	
	@Transactional
	@Modifying
	@Query("UPDATE Board b SET b.cnt = b.cnt+1 WHERE b.num=?1")
	int updateCnt(Long num);
	
	Page<Board> findByTitleContainingIgnoreCase(String title,Pageable page);
	Page<Board> findByContentContainingIgnoreCase(String content,Pageable page);
	Page<Board> findByWriterContainingIgnoreCase(String writer,Pageable page);

	Board getById(Long num);
}
