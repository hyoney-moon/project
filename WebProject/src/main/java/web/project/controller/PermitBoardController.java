package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import web.project.domain.Board;
import web.project.service.PermitBoardService;

@Controller
@RequestMapping("/permit")
public class PermitBoardController {
	@Autowired
	private PermitBoardService permitBoardService;
	
	@GetMapping("/loading")
	public String loading() {
		return "admin_board/permitBoardList";
	}
	
	@GetMapping("/getBoardList")
	@ResponseBody
	public List<Board> getBoardList() {
		List<Board> result = permitBoardService.permitBoardList();
		
		return result;
	}

}
