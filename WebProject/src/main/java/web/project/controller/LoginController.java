package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Customer;
import web.project.domain.Host;
import web.project.service.LoginService;
// 
@Controller
@SessionAttributes({"customer", "host"})
@RequestMapping("/customer")
public class LoginController {
	@Autowired
	LoginService loginservice;

	@GetMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@GetMapping("/hostLoginForm")
	public String HostLoginForm() {
		return "member/hostLoginForm";
	}
	
	@PostMapping("/login")
	public String login(Customer customer, Model model) {
		Customer findCustomer = loginservice.getCustomer(customer);
		
		if(findCustomer != null && findCustomer.getPassword().equals(customer.getPassword())) {
			model.addAttribute("customer",findCustomer);
			return "main";
		} else {
			return "redirect:loginForm";
		}
	}
	
	@PostMapping("/hostLogin")
	public String hostLogin(Host host, Model model) {
		Host findHost = loginservice.getHost(host);
		
		if(findHost != null && findHost.getPassword().equals(host.getPassword())) {
			model.addAttribute("host",findHost);
			return "index";
		} else {
			return "redirect:hostLoginForm";
		}
	}
	
}
