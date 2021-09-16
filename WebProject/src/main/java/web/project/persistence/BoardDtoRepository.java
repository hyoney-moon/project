package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.BoardDto;

public interface BoardDtoRepository extends JpaRepository<BoardDto, Integer> {

	BoardDto findByNum(Integer num);
	
	List<BoardDto> findAll();
}
