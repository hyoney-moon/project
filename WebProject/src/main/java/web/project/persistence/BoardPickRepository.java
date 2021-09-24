package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.BookInfo;

public interface BoardPickRepository extends JpaRepository<BookInfo, Long>{
	

	BookInfo findByCustId(String custId);
	
	BookInfo findByBookNum(Long bookNum);
	
	BookInfo save(BookInfo dto);
	
	List<BookInfo> findByBoardNumOrderByStartDateAsc(Long boardNum);
	//
}
