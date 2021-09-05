package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Board;
import web.project.domain.Host;
import web.project.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/boardList")
	public String insertBoard(Board board) {
		boardService.saveBoard(board);
		return "redirect:/";
	}
	
	
	
	

}
