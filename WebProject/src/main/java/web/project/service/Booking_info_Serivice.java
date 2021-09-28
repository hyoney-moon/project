package web.project.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.domain.Booking;
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
	public Board getBoard(Long boardNum) {
		Optional<Board> select = boardrepository.findById(boardNum);
		return select.get();
	}
	public Booking getBoardList(Long bookNum) {
		Booking infodto = repository.findByBookNum(bookNum);
		return null;
	}
	public Booking insertBooking(Booking dto) {
			return repository.save(dto);
	}
	@SuppressWarnings("static-access")
	@Override
	public List<String> getListDate(Long boardNum) {
		List<Booking> ListDate = repository.findByBoardNumOrderByStartDateAsc(boardNum);
		// 
		List<String> totalDate = new ArrayList<String>();
		for(int i=0; i < ListDate.size(); i++) {
			Date start = ListDate.get(i).getStartDate();
			Date end = ListDate.get(i).getEndDate();
			long diff = end.getTime() - start.getTime();
	        TimeUnit time = TimeUnit.DAYS; 
	        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
	        Date temp = start;
	        for(int j=0; j <= diffrence; j++) {
	        	
	        	SimpleDateFormat pattern1 = new SimpleDateFormat("yyyy-M-d");
				String strregdate1 = pattern1.format(temp);
				
				totalDate.add(strregdate1);
				Calendar plus = Calendar.getInstance();
				plus.setTime(temp);
				plus.add(plus.DATE, 1);
				temp = plus.getTime();
				
			}
			
		}
		return totalDate;
	}
	@Override
	public void updateBooking(Booking dto) {
		
	}
	@Override
	public Booking getbook(String custId) {
		Booking book = repository.findByCustId(custId);
		return book;
	}
	@Override
	public Booking bookNum(Long bookNum) {
		return  repository.findByBookNum(bookNum);
	}
	@Override
	public int permitUpdate(Long boardNum) {
		return repository.permitBooking(boardNum);
	}

	@Override
	public List<Booking> getListBooking(Long boardNum) {
		return repository.findByBoardNum(boardNum);
	}
		
}
