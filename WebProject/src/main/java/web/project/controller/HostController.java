package web.project.controller;

import java.util.Optional;

/*硫ㅻ쾭�뒗 湲��쓣 �뿬�윭媛� �벝 �닔 �엳�떎.
湲��� �옉�꽦�옄 �븯�굹留� 媛�吏� �닔 �엳�떎.*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import web.project.domain.Host;
import web.project.service.HostService;
@SessionAttributes("host")
@Controller
public class HostController { 

	@Autowired
	private HostService HostService;
	
	@ModelAttribute("host")
	public Host getHost() {
		return new Host();
	}
	// session에 "host" 객체가 이미 존재할 경우 method는 실행되지 않음.
	
	@GetMapping("/joinView")
	public String View() {
		return "Host/joinView";
	}
	
	@RequestMapping("/check_id")
	@ResponseBody
	public String check_id(String id) {
	
		Optional<Host> host = HostService.findHost(id);
		Host hst =  host.orElse(new Host());
		return hst.getId();//값이 없으면(null) ""로 전송된다.
	}
	
	
	@PostMapping("/join")
	public String join(Host host, Model m) {
		Host hst = HostService.saveHost(host);
		
		return "redirect:loginform";
	}  
	
	@GetMapping("/loginform")
	public String loginView(@ModelAttribute("host")Host host) {
		
		return "host/loginView";
	}
	
	@RequestMapping("/login")
	public String login(Host host, Model model) {
		Host findHost = HostService.getHost(host);
	
		if (findHost != null && findHost.getPassword().equals(host.getPassword())) {
			model.addAttribute("host", findHost);
			return "redirect:getBoardList";
		} else {
			return "redirect:loginform";
		}
	}
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();// @SessionAttributes를 활용해 Session에 남긴 데이터를 정리
		return "redirect:index.html";		
	}
	@GetMapping("/updateForm")
	public String updateForm() {
		return "host/updateForm";		
	}
	
	@PostMapping("/updateForm")
	public String update(@ModelAttribute("host") Host host) {
		HostService.saveHost(host);
		return "redirect:index.html";
	}
	
	@GetMapping("/deleteHost")
	public String delete(@ModelAttribute("host") Host host,String password, SessionStatus status) {
		Host findHost = HostService.getHost(host);
		if(findHost!=null && findHost.getPassword().equals(password)) {
			status.setComplete();
			HostService.delete(host);
		}else {
			return "redirect:/updateForm";
		}
		return "redirect:index.html";		
	}

	
}
