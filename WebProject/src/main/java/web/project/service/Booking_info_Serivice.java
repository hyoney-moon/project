package web.project.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.BoardDto;
import web.project.domain.Book_infoDto;
import web.project.persistence.BoardDtoRepository;
import web.project.persistence.BoardPickRepository;

@Service
public class Booking_info_Serivice implements BookingService {

	@Autowired
	BoardPickRepository repository;
	@Autowired
	BoardDtoRepository boardrepository;
	private List<String> list;
	
	@Override
	public BoardDto getBoard(Integer num) {
		Optional<BoardDto> select = boardrepository.findById(num);
		return select.get();
	}
	public void insertBooking(Book_infoDto dto) {
			repository.save(dto);
	}
	@Override
	public String[] getListDate(Integer num) {
		List<Book_infoDto> ListDate = repository.findByNumOrderByRegdateAsc(num);
		String[] dateList = new String[ListDate.size()];
		for(int i=0; i < ListDate.size(); i++) {
			SimpleDateFormat pattern = new SimpleDateFormat("yyyy-M-d");
			String strregdate = pattern.format(ListDate.get(i).getStartDate());
			dateList[i]=strregdate;
			System.out.println(strregdate);
		}
		return dateList;
	}
	
	

}
