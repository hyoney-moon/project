package web.project.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.Booking;

public interface BoardPickRepository extends JpaRepository<Booking, Long>{
	

	Booking findByCustId(String custId);
	
	Booking findByBookNum(Long bookNum);
	
	Booking save(Booking dto);
	
	List<Booking> findByBoardNumOrderByStartDateAsc(Long boardNum);
	//
	
	@Modifying
	   @Transactional
	   @Query("update Booking b set b.permit = 1 where b.bookNum = ?1")
	   void permitBooking(long bookNum);
	   
	   @Modifying
	   @Transactional
	   @Query("update Booking b set b.permit = 2 where b.bookNum = ?1")
	   void rejectBooking(long bookNum);

	List<Booking> findByBoardNum(Long boardNum);
	   
}
