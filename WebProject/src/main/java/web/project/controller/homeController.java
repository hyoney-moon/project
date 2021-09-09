package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.project.domain.Category;
import web.project.service.CategoryService;

@Controller
public class homeController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/login/index")
	public String loginForm() {
		return "login/index";
	}
	
	@RequestMapping("/login/hostlogin")
	public String hostLoginForm() {
		return "login/hostLoginForm";
	}

	@RequestMapping("/search")
	public String searchForm() {
		return "search/searchForm";
	}
	
	@RequestMapping("/postBoard")
	public String postBoard(Model model) {
		List<Category> cList = categoryService.selectCate();
		model.addAttribute("cList", cList);
		return "host_board/postBoard";
	}
	
	@RequestMapping("/joinForm")
	public String View() {
		return "login/joinForm";
	}
}
