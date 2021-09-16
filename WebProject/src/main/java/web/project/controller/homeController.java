package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.PreBoard;
import web.project.domain.Category;
import web.project.domain.FrontImg;
import web.project.domain.Host;
import web.project.domain.Img;
import web.project.service.PreBoardService;
import web.project.service.CategoryService;
import web.project.service.FrontImgService;
import web.project.service.ImgService;

@SessionAttributes({"customer","host"})
@Controller
public class homeController {
	
	@ModelAttribute("host")
	public Host getHost() {
		return new Host();
	}
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PreBoardService boardService;
	@Autowired
	private FrontImgService fiService;
	@Autowired
	private ImgService imgService;
	
	@RequestMapping("/login/index")
	public String loginForm() {
		return "login/index";
	}
	
	//호스트로그인
	@RequestMapping("/login/hostlogin")
	public String hostLoginForm() {
		return "login/hostLoginForm";
	}
	
	//검색
	@RequestMapping("/search")
	public String searchForm() {
		return "search/searchForm";
	}
	
	//공간 등록
	@RequestMapping("/postBoard")
	public String postBoard(Model model) {
		List<Category> cList = categoryService.selectCate();
		model.addAttribute("cList", cList);
		return "host_board/postBoard";
	}
	
	
}
