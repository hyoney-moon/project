package web.project.service;


import java.util.List;

import web.project.domain.Board;
import web.project.domain.BookInfo;


public interface BookingService {

	Board getBoard(Long boardNum);
	
	
	void insertBooking(BookInfo dto);
	
	
	List<String> getListDate(Long boardNum);


	void updateBooking(BookInfo dto);
}
