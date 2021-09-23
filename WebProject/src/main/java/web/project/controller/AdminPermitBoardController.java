package web.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import web.project.domain.Board;
import web.project.service.AdminPermitBoardService;

@Controller
@RequestMapping("/permit")
public class AdminPermitBoardController {
	@Autowired
	private AdminPermitBoardService adminPermitBoardService;
	
	// 승인 대기 게시글 조회
	@GetMapping("/preBoard")
	public String loading() {
		return "admin_board/permitBoardList";
	}
	
	// 승인 대기 게시글 조회(ajax 호출)
	@GetMapping("/getPreBoard")
	@ResponseBody
	public List<Board> getBoardList() {
		List<Board> result = adminPermitBoardService.permitBoardList();
		
		return result;
	}
	
	// 게시글 승인
	@PostMapping("/permitBoard")
	public void permitBoard(@RequestBody List<Board> board) {
		List<Long> boardNum = new ArrayList<>();
		
		 for(int i=0; i < board.size(); i++) { 
		 boardNum.add(board.get(i).getBoardNum()); 
		 }
		 
		 adminPermitBoardService.permitBoard(boardNum);
	}
	
	// 승인 전 게시글 삭제
	@PostMapping("/rejectBoard")
	public void deletePermitBoard(@RequestBody List<Board> board) {
		List<Long> boardNum = new ArrayList<>();
		
		for(int i=0; i < board.size(); i++) {
			boardNum.add(board.get(i).getBoardNum());
		}
		
		adminPermitBoardService.deletePermitBoard(boardNum);
	}
}
