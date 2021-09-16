package web.project.service;


import java.util.List;

import web.project.domain.Board;
import web.project.domain.Book_infoDto;


public interface BookingService {

	Board getBoard(Long nuboardNumm);
	
	
	void insertBooking(Book_infoDto dto);
	
	
	List<String> getListDate(Long boardNum);


	void updateBooking(Book_infoDto dto);
}
