package web.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
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

import web.project.domain.Board;
import web.project.domain.Category;
import web.project.domain.Customer;
import web.project.service.BoardService;
import web.project.service.CategoryService;
import web.project.service.LoginService;
import web.project.service.MemberService;
import web.project.service.mainboardService;
// 
@Controller
@SessionAttributes("customer")
@RequestMapping("/customer")
public class CustLoginController implements ApplicationContextAware{
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private mainboardService service;
	@Autowired
	private CategoryService cateService;
	@Autowired
	private MemberService memberService;
	
	private WebApplicationContext context = null;
	
	
	//회원 메인
	@RequestMapping("/main")
	public String mainStart(Model m) {
		List<Board> dto = service.getBoardList();
		m.addAttribute("board",dto);
		// 카테고리 리스트 출력
		List<Category> category = cateService.selectCate();
		m.addAttribute("category",category);
		return "custmain/main";
	}
	
	// 회원가입 폼
		@RequestMapping("/joinForm")
		public String joinForm() {
			return "custmain/register";
		}
		
		// 회원가입
		@PostMapping("/join")
		public String join(Customer customer, MultipartFile profile2) {
			String path = uploadFile(profile2);
			customer.setProfile(path);
			memberService.joinMember(customer);
			customer.setJoinDate(new Date());
			return "custmain/main";
		}
		
		// 로그인 폼
		@GetMapping("/loginForm")
		public String loginForm() {
			return "custmain/login";
		}
		
		// 로그인
		@PostMapping("/login")
		public String login(Customer customer, Model m) {
			Customer findCustomer = memberService.loginCustomer(customer);
			
			if(findCustomer != null && findCustomer.getPassword().equals(customer.getPassword())) {
				m.addAttribute("findCustomer",findCustomer);
				return "member/loginSucecss";
			} else {
				return "redirect:main";
			}
		}
		
		// 로그아웃
		@GetMapping("/logout")
		public String logout(SessionStatus status) {
			status.setComplete();
			return "custmain/main";
		}
		
		// 회원정보 수정 폼
		@GetMapping("/updateForm")
		public String updateForm() {
			return "custmain/updateForm";
		}
		
		// 회원정보 수정
		@PostMapping("/update")
		public String update(@ModelAttribute("customer") Customer customer, MultipartFile profile2) {
			String path = uploadFile(profile2);
			customer.setProfile(path);
			memberService.joinMember(customer);
			return "custmain/updateSuccess";
		}
		
		// 회원 탈퇴
		@PostMapping("/delete")
		public String delete(@ModelAttribute("customer") Customer customer, String password, SessionStatus status) {
			Customer findCustomer = memberService.loginCustomer(customer);
			if(findCustomer != null && findCustomer.getPassword().equals(password)) {
				status.setComplete();
				memberService.delete(customer);
				return "custmain/deleteSuccess";
			} else {
				return "redirect:updateForm";
			}
			
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
