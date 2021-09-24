package web.project.controller;


import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.Setter;
import lombok.extern.java.Log;
import web.project.domain.Board;
import web.project.domain.BookInfo;
import web.project.domain.BookingDto;
import web.project.domain.Customer;
import web.project.service.BoardService;
import web.project.service.BookingService;
import web.project.service.KakaoPay;
 
@Log
@Controller
@SessionAttributes("customer")
public class KakaoPayController {
	
	@Autowired
    BookingService booking;
	@Autowired
	BoardService board;
	
    @Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
    
    
    @GetMapping("/kakaoPay")
    public String kakaoPayGet(BookingDto dto,Model m) {
    	m.addAttribute("BookingDto", dto);
        return "custmain/kakaopay";
    }
    
    @PostMapping("/kakaoPay")
    public String kakaoPay(@ModelAttribute("customer")Customer custId, BookInfo booking, BookingDto dto ) {
        System.out.println("kakaoPay post............................................");
        BookInfo afterInsert = insertbooking(booking, dto, custId);
		Board hostNum = board.getBoard(dto.getBoardNum());
		booking.setBoard(hostNum);
        return "redirect:" + kakaopay.kakaoPayReady(custId,afterInsert);
    }
    
    @GetMapping("/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model,@ModelAttribute("customer") Customer custId, Long bookNum) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        // 해당 결제일 정보 출력해주기
        BookInfo book = booking.bookNum(bookNum);
        model.addAttribute("book",book);
        //공간명 출력해주시길
        Board boardName = board.getBoardNum(book.getBoardNum());
        model.addAttribute("boardNum",boardName);
        return "custmain/success";
        // 해당 정보 성공시
    }
    @GetMapping("/successmain")
    public String mainback() {
    	return "custmain/main";
    }
    
    
    public BookInfo insertbooking(BookInfo dto , BookingDto bdto, Customer custId) {
		Board numBoard = booking.getBoard(bdto.getBoardNum());
		Board hostNum = board.getBoard(bdto.getBoardNum());
		//session 값 불러와서 아이디 저장해서 예약하기
		dto.setCustId(custId.getCustId());
		
		// 호스트 아이디 불러와서 예약 시 호스트쪽으로 값 전달
		dto.setHostId(hostNum.getHostId());
		dto.setBoardNum(bdto.getBoardNum());
		dto.setStartDate(bdto.getStartDatepicker());
		dto.setEndDate(bdto.getEndDatepicker());
		dto.setPeople(bdto.getCount());
		dto.setRegDate(new Date());
		//예약한 날짜 만큼 금액 곱해서 청구하기
		Date start = bdto.getStartDatepicker();
		Date end = bdto.getEndDatepicker();
		long diff = end.getTime() - start.getTime();
		TimeUnit time = TimeUnit.DAYS; 
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        int price = (int)(numBoard.getPrice()*diffrence);
		dto.setPrice(price);
		return booking.insertBooking(dto);
		//return "redirect:/main";
	}
}
 
