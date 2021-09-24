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
import web.project.domain.BookInfo;
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
	public BookInfo getBoardList(Long bookNum) {
		BookInfo infodto = repository.findByBookNum(bookNum);
		return null;
	}
	public BookInfo insertBooking(BookInfo dto) {
			return repository.save(dto);
	}
	@SuppressWarnings("static-access")
	@Override
	public List<String> getListDate(Long boardNum) {
		List<BookInfo> ListDate = repository.findByBoardNumOrderByStartDateAsc(boardNum);
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
	public void updateBooking(BookInfo dto) {
		
	}
	@Override
	public BookInfo getbook(String custId) {
		BookInfo book = repository.findByCustId(custId);
		return book;
	}
	@Override
	public BookInfo bookNum(Long bookNum) {
		return  repository.findByBookNum(bookNum);
	}
		
}
