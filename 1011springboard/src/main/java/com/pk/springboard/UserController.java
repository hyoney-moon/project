package com.pk.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pk.springboard.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/register", method=RequestMethod.GET)
	//단순 page 이동은 리턴없이 생성해도 됩니다.
	//뷰 이름이 user/register가 됩니다.
	public void register(Model model) {}
	
	@RequestMapping(value="/user/register",
			method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest request) {
		userService.register(request);
		//회원가입을 처리하고 메인으로 리다이렉트
		//데이터베이스에 변화를 주면 반드시 리다이렉트
		return "redirect:/";
	}
}







