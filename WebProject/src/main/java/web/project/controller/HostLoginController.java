package web.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import web.project.domain.Host;
import web.project.service.HostLoginService;

@SessionAttributes("host")
@Controller
@RequestMapping("/host")
public class HostLoginController implements ApplicationContextAware{
	
	@Autowired
	HostLoginService hostLoginService;
	
	private WebApplicationContext context = null;
	
	//호스트 메인
	@RequestMapping("/hostmain")
	public String hostMain() {
		return "host_main/hostmain";
	}
	//호스트 회원가입 폼
	@RequestMapping("/hostJoinForm")
	public String hostJoinForm() {
		return "host_main/hostJoinForm";
	}
	//호스트 회원가입
	@PostMapping("/hostJoin")
	public String hostJoin(Host host, MultipartFile profile2) {
		String path = uploadFile(profile2);
		host.setProfile(path);
		hostLoginService.joinHost(host);
		host.setJoinDate(new Date());
		return "redirect:hostmain";
	}
	//호스트 탈퇴
	@PostMapping("/hostDelete")
	public String hostDelete(@ModelAttribute("host") Host host, String password, SessionStatus status) {
		Host findHost = hostLoginService.getHost(host);
		if(findHost != null && findHost.getPassword().equals(password)) {
			status.setComplete();
			hostLoginService.hostDelete(host);
			return "redirect:main";
		} else {
			return "redirect:updateForm";
		}
	}
	
	//logo 클릭시
	@RequestMapping("/logoClick")
	public String logoMain() {
		return "redirect:hostmain";
	}
	
	//로그인 폼
	@RequestMapping("/hostLoginForm")
	public String loginForm() {
		return "host_main/hostLoginForm";
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
	
	//프로필 사진 업로드용
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
	}
	
	//회원정보 수정 폼
	@RequestMapping("/hostUpdateForm")
	public String hostUpdateForm() {
		return "host_main/hostUpdateForm";
	}
	//회언정보 수정
	@PostMapping("/hostUpdate")
	public String hostUpdate(@ModelAttribute("host") Host host, MultipartFile profile2) {
		String path = uploadFile(profile2);
		host.setProfile(path);
		hostLoginService.joinHost(host);
		return "redirect:hostmain";
	}
	
	private String uploadFile(MultipartFile profile2) {
	 
		String oriName = profile2.getOriginalFilename(); //저장 된 파일의 원본 이름
		int index = oriName.lastIndexOf(".");
		String ext = oriName.substring(index+1); //파일 이름 겹치지 않게 지정
		Random r = new Random();
		String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;
		
		String path = context.getServletContext().getRealPath("/profile/"+fileName); 
		System.out.println(path);
		try {
			profile2.transferTo(new File(path));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return "/profile/"+fileName;
	}
	

}

