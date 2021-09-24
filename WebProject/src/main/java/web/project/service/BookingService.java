package web.project.service;


import java.util.List;

import web.project.domain.Board;
import web.project.domain.BookInfo;
import web.project.domain.BookingDto;


public interface BookingService {
	
	
	BookInfo bookNum(Long bookNum);
	
	BookInfo getbook(String custId);

	Board getBoard(Long boardNum);
	
	
	BookInfo insertBooking(BookInfo dto);
	
	
	List<String> getListDate(Long boardNum);


	void updateBooking(BookInfo dto);


}
