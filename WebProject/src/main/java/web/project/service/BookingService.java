package web.project.service;


import java.util.List;

import web.project.domain.BoardDto;
import web.project.domain.Book_infoDto;


public interface BookingService {

	BoardDto getBoard(Integer num);
	
	
	void insertBooking(Book_infoDto dto);
	
	
	String[] getListDate(Integer num);
}
