package web.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.project.domain.Member;
import web.project.service.MemberService;

/**
 * 회원 관련 요청을 처리해 줄 Controller
 * member/register 요청을 처리해 줄 메소드 보유
 */
@SessionAttributes("customer")
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "member/register";
	}
	@PostMapping("/join")
	public String join(Member member) {
		memberService.joinMember(member);
		
		return "member/join";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(Member member) {
		Member findMember = memberService.loginMember(member);
		
		if (findMember != null && findMember.getPassword().equals(member.getPassword())) {
			return "home";
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션을 초기화
		session.invalidate();
		return "redirect:../";
	}
	
	/*
	@RequestMapping(value = "member/register", method = RequestMethod.GET)
	// 단순 page 이동은 리턴 값 없이 생성해도 된다
	// view 이름은 member/register 가 된다
	public void register(Model model) {}
	
	@RequestMapping(value="/member/register",
			method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest request) {
		memberService.register(request);
		// 회원가입 처리후 메인으로 리다이렉트
		// DB에 변화를 주면 반드시 리다이렉트 해야 함
		return "redirect:/";
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	// 단순 page 이동은 리턴 값 없이 생성해도 된다
	// view 이름은 member/login 가 된다
	public void login(Model model) {}
	
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session,
			RedirectAttributes attr) {
		Member member = memberService.login(request);
		// 로그인 실패할 시 member 에 null 이라고 저장
		if(member == null) {
			session.setAttribute("member",null);
			// RedirectAttributes는 리다이렉트 될 때 한 번만 데이터를 전달함
			attr.addFlashAttribute("msg" , "존재하지 않는 ID 이거나 잘못된 비밀번호 입니다.");
			return "redirect:login";
		}else {
			// login 성공하면 member 에 로그인 정보를 저장
			session.setAttribute("member" , member);
			return "redirect:../";
		}
		
	}
	
	// 로그아웃을 처리하는 메소드
	@RequestMapping(value="/member/logout",
			method=RequestMethod.GET)
	public String logout(HttpSession session) {
		//세션을 초기화
		session.invalidate();
		return "redirect:../";
	}
	*/
	
}
