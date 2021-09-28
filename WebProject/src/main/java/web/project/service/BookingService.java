package web.project.service;


import java.util.List;

import web.project.domain.Board;
import web.project.domain.Booking;
import web.project.domain.BookingDto;


public interface BookingService {
	
	
	int permitUpdate(Long boardNum);
	
	Booking bookNum(Long bookNum);
	
	
	Booking getbook(String custId);

	Board getBoard(Long boardNum);
	
	Booking insertBooking(Booking dto);
	
	
	List<String> getListDate(Long boardNum);

	List<Booking> getListBooking(Long boardNum);

	void updateBooking(Booking dto);


}
