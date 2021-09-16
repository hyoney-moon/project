package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.BoardDto;

public interface mainBoardRepository extends JpaRepository<BoardDto, Long> {

	public List<BoardDto> findByNum(Integer num);
	
	public List<BoardDto> findAll();
}
