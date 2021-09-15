package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.BoardDto;
import web.project.service.BoardService;
import web.project.service.mainboardService;

@Controller
@SessionAttributes("customerDto")
public class mainController {
	
	@Autowired
	mainboardService service;
	
	@RequestMapping("/main")
	public String mainStart(Model m) {
		List<BoardDto> dto = service.getBoardList();
		m.addAttribute("board",dto);
		return "custmain/main";
	}
	
}
