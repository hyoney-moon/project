package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Host;
import web.project.service.HostLoginService;

@SessionAttributes({"customer","host"})
@Controller
public class HostLoginController {
	
	@Autowired
	HostLoginService hostLoginService;
	
	//로그인 폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login/hostLoginForm";
	}
	//호스트 로그인
	@PostMapping("/hostLogin")
	public String hostLogin(Model model, Host host) {
		Host findHost = hostLoginService.getHost(host);
		if(findHost != null && findHost.getPassword().equals(host.getPassword())) {
			model.addAttribute("host",findHost);
			return "host_board/postBoard";
		} else {
			return "redirect:hostLoginForm";
		}
	}
	
	
	

}
