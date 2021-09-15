package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.BoardDto;
import web.project.domain.Book_infoDto;

public interface BoardPickRepository extends JpaRepository<Book_infoDto, Long>{

	
	Book_infoDto save(Book_infoDto dto);
	
	List<Book_infoDto> findByNumOrderByRegdateAsc(Integer num);
}
