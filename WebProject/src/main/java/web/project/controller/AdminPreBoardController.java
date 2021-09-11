package web.project.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;

import web.project.domain.Board;
import web.project.domain.PreBoard;
import web.project.service.AdminPreBoardService;
import web.project.service.BoardService;

@Controller
@RequestMapping("preBoard")
public class AdminPreBoardController {

	@Autowired
	private AdminPreBoardService adminPreBoardService;
	@Autowired
	private BoardService boardService;
	
	@GetMapping("preBoardList")
	public String preBoardList() {
		return "admin_board/preBoardList";
	}
	
	@GetMapping("getPreBoardList")
	@ResponseBody
	public List<PreBoard> getPreBoardList() {
		List<PreBoard> result = adminPreBoardService.PreBoardList();
		//Gson json = new Gson();
		// json.toJson(result);
		return result; 
	}
	
	@PostMapping("permission")
	public void permission(@RequestBody List<Board> board) {
		boardService.insertAllBoard(board);
	}
	
	@PostMapping("delete")
	public void delete(@RequestBody List<Long> boardNum) {
		System.out.print("test " + boardNum);
		adminPreBoardService.deletePreBoard(boardNum);
	}
}
