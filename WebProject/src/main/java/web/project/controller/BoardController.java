package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Board;
import web.project.domain.Qna;
import web.project.service.BoardService;
import web.project.service.QnaService;

@Controller
@RequestMapping("/board")
@SessionAttributes("customer")
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private QnaService qnaService;
	
	// 게시글 목록
	@GetMapping("/boardList")
	public String getBoardList(Model m, @RequestParam(name = "p", defaultValue = "1") int pNum) {
		Page<Board> pageList = boardService.getBoardList(pNum);
		List<Board> bList = pageList.getContent();
		int totalPageCount = pageList.getTotalPages();
		m.addAttribute("blist", bList);
		m.addAttribute("totalPage", totalPageCount);
		
		int begin = (pNum - 1) / 5 * 5 + 1;
		int end = begin + 5 - 1;
		if (end > totalPageCount) {
			end = totalPageCount;
			
		m.addAttribute("begin", begin);
		m.addAttribute("end", end);
		
		}
		return "host_board/getBoardList";
	}
	
	// 게시글 조회
	@GetMapping("/content/{boardNum}")
	public String getBoard(@PathVariable Long boardNum, Model m) {
		Board board = boardService.getBoard(boardNum);
		List<Qna> QnaResult = qnaService.getQnaList(boardNum);
		m.addAttribute("qna", QnaResult);
		m.addAttribute("board",board);
		return "host_board/getBoard";
	}
}
