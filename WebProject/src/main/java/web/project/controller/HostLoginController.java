package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import web.project.domain.Host;
import web.project.service.HostLoginService;

@SessionAttributes("host")
@Controller
@RequestMapping("/host")
public class HostLoginController {
	
	@Autowired
	HostLoginService hostLoginService;
	
	//호스트 메인
	@RequestMapping("/hostmain")
	public String hostMain() {
		return "host_main/hostmain";
	}
	
	//logo 클릭시
	@RequestMapping("/logoClick")
	public String logoMain() {
		return "redirect:hostmain";
	}
	
	//로그인 폼
	@RequestMapping("/hostLoginForm")
	public String loginForm() {
		return "login/hostLoginForm";
	}
	//호스트 로그인
	@PostMapping("/hostLogin")
	public String hostLogin(Model model, Host host) {
		Host findHost = hostLoginService.getHost(host);
		if(findHost != null && findHost.getPassword().equals(host.getPassword())) {
			model.addAttribute("host",findHost);
			return "redirect:hostmain";
		} else {
			return "redirect:hostLoginForm";
		}
	}
	
	//호스트 로그아웃
	@GetMapping("/hostLogout")
	public String custLogout(SessionStatus status) {
		status.setComplete();
		return "host_main/hostmain";
	}
	

}

