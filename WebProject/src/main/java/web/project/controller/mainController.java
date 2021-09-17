package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Board;
import web.project.domain.Category;
import web.project.service.BoardService;
import web.project.service.CategoryService;
import web.project.service.mainboardService;

@SessionAttributes({"host","custId"})
@Controller
public class mainController {
	
	@Autowired
	mainboardService service;
	@Autowired CategoryService cateService;
	@RequestMapping("/main")
	public String mainBoard(Model m) {
		List<Board> dto = service.getBoardList();
		m.addAttribute("board",dto);
		// 카테고리 리스트 출력
		List<Category> category = cateService.selectCate();
		m.addAttribute("category",category);
		return "custmain/main";
	}
	
	
}
