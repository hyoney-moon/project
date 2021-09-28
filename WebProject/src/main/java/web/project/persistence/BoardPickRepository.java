package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import web.project.domain.Booking;

public interface BoardPickRepository extends JpaRepository<Booking, Long>{
	
	Booking findByBoardNum(Long boardNum);

	Booking findByCustId(String custId);
	
	Booking findByBookNum(Long bookNum);
	
	Booking save(Booking dto);
	
	@Modifying
	@Transactional
	@Query("update Booking b set b.permit = 1 where b.boardNum = ?1")
	int permitBooking(Long bookNum);
	
	List<Booking> findByBoardNumOrderByStartDateAsc(Long boardNum);
}
