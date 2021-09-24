package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Booking;

public interface BoardPickRepository extends JpaRepository<Booking, Long>{
	

	Booking findByCustId(String custId);
	
	Booking findByBookNum(Long bookNum);
	
	Booking save(Booking dto);
	
	List<Booking> findByBoardNumOrderByStartDateAsc(Long boardNum);
	//
}
