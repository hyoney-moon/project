package web.project.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import web.project.domain.PreBoard;

public interface PreBoardRepository extends JpaRepository<PreBoard, Long> {

	Page<PreBoard> findByOrderByBoardNumDesc(Pageable page);

	PreBoard findByBoardNum(Long boardNum);
	
	@Transactional
	@Modifying
	@Query("UPDATE PreBoard b SET b.readcount = b.readcount+1 WHERE b.boardNum=?1")
	int updateReadcount(Long boardNum);



}
