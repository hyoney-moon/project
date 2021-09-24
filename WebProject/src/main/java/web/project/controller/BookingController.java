package web.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.catalina.Session;
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

import javassist.Loader.Simple;
import web.project.domain.Board;
import web.project.domain.Booking;
import web.project.domain.Customer;
import web.project.service.BoardService;
import web.project.service.BookingService;
import web.project.service.HostLoginService;

@Controller
@SessionAttributes("customer") 
public class BookingController {

	@Autowired
	BookingService service;
	@Autowired
	BoardService boardservice;
	
		//요청 페이지 출력
//		@GetMapping("/bookingpage/{boardNum}")
//		public String getbookingView(@PathVariable(name = "boardNum") Long boardNum,Model m) {
//			Board board =  service.getBoard(boardNum);
//			
//			m.addAttribute("board", board);
//			//사용자가 받는 데이터값 유효성 검사 단계
//			 List<String> dateList = service.getListDate(boardNum);
//			Gson json = new Gson();
//			
//			m.addAttribute("dateList",json.toJson(dateList));
//			return "custmain/custbooking";
//		}
		//페이지 결과 처리메소드
		@PostMapping("/bookingpage/{boardNum}")
		public String insertbooking(Booking dto,@PathVariable(name = "boardNum") Long boardNum, int count,@DateTimeFormat(pattern="yyyy-MM-dd") Date startDatepicker,@DateTimeFormat(pattern="yyyy-MM-dd") Date endDatepicker,@ModelAttribute("customer")Customer custId) throws ParseException {
			Board board = service.getBoard(boardNum);
			Board hostNum = boardservice.getBoard(boardNum);
			//session 값 불러와서 아이디 저장해서 예약하기
			dto.setCustId(custId.getCustId());
			
			// 호스트 아이디 불러와서 예약 시 호스트쪽으로 값 전달
			dto.setHostId(hostNum.getHostId());
			dto.setBoardNum(boardNum);
			dto.setStartDate(startDatepicker);
			dto.setEndDate(endDatepicker);
			dto.setPeople(count);
			dto.setRegDate(new Date());
			//예약한 날짜 만큼 금액 곱해서 청구하기
			Date start = startDatepicker;
			Date end = endDatepicker;
			long diff = end.getTime() - start.getTime();
			TimeUnit time = TimeUnit.DAYS; 
	        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
	        int price = (int)(board.getPrice()*diffrence);
			dto.setPrice(price);
			service.insertBooking(dto);
			return "redirect:/main";
		}
	@RequestMapping("/home")
	public void updateBooking(Booking dto,@ModelAttribute("customerDto") Customer cust) {
		service.updateBooking(dto);
	}
		
		
		//카카오페이 페이지 이동 메소드
	  	@GetMapping("/bookingpage/bookingPay") 
		public String bookingPay() {
		  return"custmain/kakaopay"; 
		  }
}
