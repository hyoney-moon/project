package web.project.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Book_infoDto;
import web.project.domain.CustomerDto;
import web.project.service.BookingService;

@Controller
@SessionAttributes("customerDto")
public class BookingController {

	@Autowired
	BookingService service;
	
	@RequestMapping("/home")
	public void updateBooking(Book_infoDto dto,@ModelAttribute("customerDto") CustomerDto cust) {
		service.updateBooking(dto);
		
	}
	
	  @RequestMapping("bookingPay") public String bookingPay() { 
		  return"custmain/kakaopay"; 
		  }
	 
	
	@RequestMapping("/booking")
	public String booking() {
		return "custmain/custbooking";
	}
	
	
	
}
