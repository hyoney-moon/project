package web.project.service;


import java.util.Date;

import web.project.domain.Book_infoDto;


public interface BookingService {

	Book_infoDto getBoardList(Integer num);
	
	void updateBooking(Book_infoDto dto);
}
