package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.BoardDto;
import web.project.domain.Book_infoDto;

public interface BoardPickRepository extends JpaRepository<Book_infoDto, Long>{

	Book_infoDto findByNum(Integer num);
	
	Book_infoDto save(Book_infoDto dto);
}
