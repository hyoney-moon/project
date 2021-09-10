package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import web.project.domain.Board;
import web.project.domain.CustQna;
import web.project.domain.Customer;
import web.project.domain.HostQna;
import web.project.service.BoardService;
import web.project.service.QnaService;
// 
@Controller
@RequestMapping("/board")
@SessionAttributes("customer")
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
	
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
		List<CustQna> custQnaResult = qnaService.getQnaList(boardNum);
		
		m.addAttribute("custQna", custQnaResult);
		m.addAttribute("board",board);
		return "host_board/getBoard";
	}
	
	// 일반회원 댓글 출력(ajax)
	@RequestMapping(value = "/comment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String commentList(Long boardNum) throws Exception {
		List<CustQna> custQnaResult = qnaService.getQnaList(boardNum);
		Gson json = new Gson();
		return json.toJson(custQnaResult);
	}
	// 호스트 댓글 출력(ajax) 
	@RequestMapping(value = "/replyComment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String replyCommentList(Long boardNum) throws Exception {
		List<HostQna> hostQnaResult = qnaService.getHostQnaList(boardNum);
		Gson json = new Gson();
		return json.toJson(hostQnaResult);
	}
}
