package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import web.project.domain.Customer;
import web.project.domain.Host;
import web.project.service.LoginService;
// 
@Controller
@SessionAttributes("customer")
@RequestMapping("/customer")
public class CustLoginController {
	@Autowired
	LoginService loginservice;
	
	//회원 메인
	@RequestMapping("/main")
	public String mainStart() {
		return "custmain/main";
	}
	//회원 로그인 폼
	@GetMapping("/custloginForm")
	public String loginForm() {
		return "login/custLoginForm";
	}
	//회원 로그인
	@PostMapping("/custlogin")
	public String login(Customer customer, Model model) {
		Customer findCustomer = loginservice.getCustomer(customer);
		
		if(findCustomer != null && findCustomer.getPassword().equals(customer.getPassword())) {
			model.addAttribute("customer",findCustomer);
			return "redirect:main";
		} else {
			return "redirect:loginForm";
		}
	}
	
	//회원 로그아웃
	@GetMapping("/custLogout")
	public String custLogout(SessionStatus status) {
		status.setComplete();
		return "custmain/main";
	}
	
}
