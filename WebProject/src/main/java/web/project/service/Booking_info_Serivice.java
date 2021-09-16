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
	@SuppressWarnings("static-access")
	@Override
	public List<String> getListDate(Integer num) {
		List<Book_infoDto> ListDate = repository.findByNumOrderByStartDateAsc(num);
		List<String> totalDate = new ArrayList<String>();
		for(int i=0; i < ListDate.size(); i++) {
			Date start = ListDate.get(i).getStartDate();
			Date end = ListDate.get(i).getEndDate();
			long diff = end.getTime() - start.getTime();
			System.out.println(diff);
	        TimeUnit time = TimeUnit.DAYS; 
	        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
	        System.out.println("diffrence::"+diffrence);
	        Date temp = start;
	        for(int j=0; j <= diffrence; j++) {
	        	
	        	SimpleDateFormat pattern1 = new SimpleDateFormat("yyyy-M-d");
				String strregdate1 = pattern1.format(temp);
				
				totalDate.add(strregdate1);
				System.out.println(j);
				Calendar plus = Calendar.getInstance();
				plus.setTime(temp);
				plus.add(plus.DATE, 1);
				temp = plus.getTime();
				
				System.out.println(strregdate1);
			}
			
		}
		return totalDate;
	}
	
	

}
