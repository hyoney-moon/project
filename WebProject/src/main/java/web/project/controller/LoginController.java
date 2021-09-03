package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Customer;
import web.project.service.LoginService;

@SessionAttributes("customer")
@Controller
@RequestMapping("/customer")
public class LoginController {
	@Autowired
	LoginService loginservice;

	@GetMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@PostMapping("/login")
	public String login(Customer customer, Model model) {
		Customer findCustomer = loginservice.getCustomer(customer);
		
		if(findCustomer != null && findCustomer.getPassword().equals(customer.getPassword())) {
			System.out.print("okay");
			model.addAttribute("customer",findCustomer);
			return "index";
		} else {
			System.out.print("no");
			return "redirect:loginForm";
		}
				
	}
	
}
