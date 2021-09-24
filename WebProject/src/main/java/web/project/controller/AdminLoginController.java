package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import web.project.domain.Admin;
import web.project.service.AdminLoginService;

@SessionAttributes("admin")
@Controller
@RequestMapping("/adminLogin")
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginService;
	
	// 관리자 로그인 폼
	@GetMapping("/loginForm")
	public String loginForm() {
		return "login/adminLoginForm";
	}
	
	// 관리자 로그인
	@PostMapping("/login")
	public String adminLogin(Model model, Admin admin) {
		Admin findAdmin = adminLoginService.getAdmin(admin);
		if(findAdmin != null && findAdmin.getPassword().equals(admin.getPassword())) {
			model.addAttribute("admin",findAdmin);
			System.out.print("비밀번호일치");
			return "admin_main/adminMainPage";
		} else {
			return "login/adminLoginForm";
		}
	}
	
	
	// 관리자 로그아웃
	@GetMapping("/logout")
	public String adminLogout(SessionStatus status) {
		status.setComplete();
		return "admin_main/adminMainPage";
	}
	
	
	
}
