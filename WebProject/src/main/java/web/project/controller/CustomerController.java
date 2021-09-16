package web.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import web.project.domain.Customer;
import web.project.service.MemberService;

/**
 * 회원 관련 요청을 처리해 줄 Controller
 * member/register 요청을 처리해 줄 메소드 보유
 */
@SessionAttributes("customer")
@Controller
public class CustomerController {
	
	@Autowired
	private MemberService memberService;
	
	
	// 회원가입 폼
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "member/register";
	}
	
	// 회원가입
	@PostMapping("/join")
	public String join(Customer customer) {
		memberService.joinMember(customer);
		
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
	public String update(@ModelAttribute("customer") Customer customer) {
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
	
	
}
