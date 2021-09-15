package web.project.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Book_infoDto;
import web.project.persistence.BoardPickRepository;

@Service
public class Booking_info_Serivice implements BookingService {

	@Autowired
	BoardPickRepository repository;
	
	@Override
	public Book_infoDto getBoardList(Integer bookNum) {
		Book_infoDto infodto = repository.findByBookNum(bookNum);
		return null;
	}
	public void updateBooking(Book_infoDto dto) {
			repository.save(dto);
	}

}
