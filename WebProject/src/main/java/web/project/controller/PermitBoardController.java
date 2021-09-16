package web.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// 승인 대기 게시글 조회
	@GetMapping("/loading")
	public String loading() {
		return "admin_board/permitBoardList";
	}
	
	// 승인 대기 게시글 조회(ajax 호출)
	@GetMapping("/getBoardList")
	@ResponseBody
	public List<Board> getBoardList() {
		List<Board> result = permitBoardService.permitBoardList();
		
		return result;
	}
	
	// 게시글 승인
	@PostMapping("/update")
	public void permitBoard(@RequestBody List<Board> board) {
		List<Long> boardNum = new ArrayList<>();
		
		 for(int i=0; i < board.size(); i++) { 
		 boardNum.add(board.get(i).getBoardNum()); 
		 }
		 
		 permitBoardService.permitBoard(boardNum);
	}
	
	// 승인 전 게시글 삭제
	@PostMapping("/deletePermitBoard")
	public void deletePermitBoard(@RequestBody List<Board> board) {
		List<Long> boardNum = new ArrayList<>();
		
		for(int i=0; i < board.size(); i++) {
			boardNum.add(board.get(i).getBoardNum());
		}
		
		permitBoardService.deletePermitBoard(boardNum);
	}
	
}
