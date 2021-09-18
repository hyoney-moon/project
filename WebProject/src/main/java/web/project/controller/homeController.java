package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Category;
import web.project.domain.FrontImg;
import web.project.domain.Host;
import web.project.domain.Img;
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
	private FrontImgService fiService;
	@Autowired
	private ImgService imgService;
	
	@RequestMapping("/login/index")
	public String loginForm() {
		return "login/index";
	}
	
	
	//검색
	@RequestMapping("/search")
	public String searchForm() {
		return "search/searchForm";
	}
	
	
}
