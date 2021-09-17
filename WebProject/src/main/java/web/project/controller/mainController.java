package web.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"host", "customer"})
@Controller
public class mainController {
	
	

	@RequestMapping("/main")
	public String mainStart() {
		return "custmain/main";
	}
	
	@RequestMapping("/hostmain")
	public String hostMain() {
		return "host_main/hostmain";
	}
	
	@RequestMapping("/adminmain")
	public String adminMain() {
		return "admin_main/adminmain";
	}
}
