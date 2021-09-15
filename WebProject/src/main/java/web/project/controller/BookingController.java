package web.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import web.project.domain.Board;
import web.project.domain.BoardDto;
import web.project.domain.Book_infoDto;
import web.project.domain.CustomerDto;
import web.project.domain.HostDto;
import web.project.service.BookingService;

@Controller
@SessionAttributes({"cust_id","host_id","board"})
public class BookingController {

	@Autowired
	BookingService service;
	
		//요청 페이지 출력
		@GetMapping("/bookingpage/{num}")
		public String getbookingView(@PathVariable(name = "num") Integer num,Model m) {
			BoardDto board =  service.getBoard(num);
			System.err.println(board.getHeadcnt());
			m.addAttribute("board", board);
			//사용자가 받는 데이터값 유효성 검사 단계
			String[] dateList = service.getListDate(num);
			Gson json = new Gson();
			
			m.addAttribute("dateList",json.toJson(dateList));
			return "custmain/custbooking";
		}
		//페이지 결과 처리메소드
		@PostMapping("/bookingpage/{num}")
		public String insertbooking(Book_infoDto dto,@PathVariable(name = "num") Integer num, int count,@DateTimeFormat(pattern="yyyy-MM-dd") Date datepicker, String host_id, String cust_id) throws ParseException {
			
			dto.setPrice(count);
			dto.setCust_id("kng00233");
			dto.setHost_id("dddd");
			dto.setNum(num);
			dto.setStartDate(datepicker);
			//enddate 값 입력 받기
			dto.setPeople(count);
			service.insertBooking(dto);
			return "redirect:/main";
		}
		
		
		//카카오페이 페이지 이동 메소드
	  	@GetMapping("/bookingPay") 
		public String bookingPay() {
		  return"custmain/kakaopay"; 
		  }
	
	
	@RequestMapping("/booking")
	public String bookingpage() {
		return "custmain/custbooking";
	}
	
	
}
