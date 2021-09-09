package web.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Board;
import web.project.domain.Host;
import web.project.service.BoardService;

@SessionAttributes("host")
@Controller
public class BoardController {
	
	@ModelAttribute("host")
	public Host getHost() {
		return new Host();
	}
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/boardList")
	public String insertBoard(Board board, @ModelAttribute("host")Host host) {
		board.setHostid(host.getHostid());
		boardService.saveBoard(board);
		return "redirect:/";
	}
	
	
	
	

}
