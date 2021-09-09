package web.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	
	@RequestMapping("/login/index")
	public String loginForm() {
		return "login/index";
	}
	
	@RequestMapping("/login/hostlogin")
	public String hostLoginForm() {
		return "login/hostLoginForm";
	}

	@RequestMapping("/search")
	public String searchForm() {
		return "search/searchForm";
	}
	
	@RequestMapping("/postBoard")
	public String postBoard() {
		return "host_board/postBoard";
	}
	
	@RequestMapping("/joinForm")
	public String View() {
		return "login/joinForm";
	}
}
