package web.project.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import web.project.domain.Customer;
import web.project.service.MemberService;

/**
 * 회원 관련 요청을 처리해 줄 Controller
 * member/register 요청을 처리해 줄 메소드 보유
 */
@SessionAttributes("customer")
@Controller
public class CustomerController implements ApplicationContextAware {
	
	@Autowired
	private MemberService memberService;
	
	private WebApplicationContext context = null;
	
	// 회원가입 폼
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "member/register";
	}
	
	// 회원가입
	@PostMapping("/join")
	public String join(Customer customer, MultipartFile profile2) {
		String path = uploadFile(profile2);
		customer.setProfile(path);
		memberService.joinMember(customer);
		customer.setJoinDate(new Date());
		customer.setCash("100000");
		return "member/join";
	}
	
	// 로그인 폼
	@GetMapping("/loginForm")
	public String loginForm() {
		return "member/login";
	}
	
	// 로그인
	@PostMapping("/login")
	public String login(Customer customer, Model m) {
		Customer findCustomer = memberService.loginCustomer(customer);
		
		if(findCustomer != null && findCustomer.getPassword().equals(customer.getPassword())) {
			m.addAttribute("findCustomer",findCustomer);
			return "member/loginSucecss";
		} else {
			return "redirect:/";
		}
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	
	// 회원정보 수정 폼
	@GetMapping("/updateForm")
	public String updateForm() {
		return "member/updateForm";
	}
	
	// 회원정보 수정
	@PostMapping("/update")
	public String update(@ModelAttribute("customer") Customer customer, MultipartFile profile2) {
		String path = uploadFile(profile2);
		customer.setProfile(path);
		memberService.joinMember(customer);
		return "member/updateSuccess";
	}
	
	// 회원 탈퇴
	@PostMapping("/delete")
	public String delete(@ModelAttribute("customer") Customer customer, String password, SessionStatus status) {
		Customer findCustomer = memberService.loginCustomer(customer);
		if(findCustomer != null && findCustomer.getPassword().equals(password)) {
			status.setComplete();
			memberService.delete(customer);
		} else {
			return "redirect:/updateForm";
		}
		return "member/deleteSuccess";
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = (WebApplicationContext) applicationContext;
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
