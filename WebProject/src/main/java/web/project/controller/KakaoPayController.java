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
import web.project.domain.Booking;
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
    public String kakaoPay(@ModelAttribute("customer")Customer custId, Booking booking, BookingDto dto ) {
        System.out.println("kakaoPay post............................................");
        Booking afterInsert = insertbooking(booking, dto, custId);
		Board hostNum = board.getBoard(dto.getBoardNum());
		booking.setBoard(hostNum);
        return "redirect:" + kakaopay.kakaoPayReady(custId,afterInsert);
    }
    
    @GetMapping("/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model,@ModelAttribute("customer") Customer custId, Long bookNum) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        // ?????? ????????? ?????? ???????????????
        Booking book = booking.bookNum(bookNum);
        model.addAttribute("book",book);
        //????????? ??????????????????
        Board boardName = board.getBoardNum(book.getBoardNum());
        model.addAttribute("boardNum",boardName);
        return "custmain/success";
        // ?????? ?????? ?????????
    }
    @GetMapping("/successmain")
    public String mainback() {
    	return "custmain/main";
    }
    
    
    public Booking insertbooking(Booking dto , BookingDto bdto, Customer custId) {
		Board numBoard = booking.getBoard(bdto.getBoardNum());
		Board hostNum = board.getBoard(bdto.getBoardNum());
		//session ??? ???????????? ????????? ???????????? ????????????
		dto.setCustId(custId.getCustId());
		
		// ????????? ????????? ???????????? ?????? ??? ?????????????????? ??? ??????
		dto.setHostId(hostNum.getHostId());
		dto.setBoardNum(bdto.getBoardNum());
		dto.setStartDate(bdto.getStartDatepicker());
		dto.setEndDate(bdto.getEndDatepicker());
		dto.setPeople(bdto.getCount());
		dto.setRegDate(new Date());
		//????????? ?????? ?????? ?????? ????????? ????????????
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
 
