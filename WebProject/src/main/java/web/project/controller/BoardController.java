package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.project.domain.Board;
import web.project.domain.Host;
import web.project.service.BoardService;

@SessionAttributes("host")
@Controller
public class BoardController {
	//session에 host가 없으면 실행, 있으면 실행되지 않는다.
	@ModelAttribute("host")
	public Host getHost() {
		return new Host();
	}
	
	@Autowired
	private BoardService boardService;

	@RequestMapping("/getBoardList")
	public String getBoardList(Model m, @RequestParam(name = "p", defaultValue = "1") int pNum, @ModelAttribute("host")Host host, 
			String search, @RequestParam(defaultValue = "-1") int searchn) {
		if(Host.getId() == null) {
			return "redirect:loginform";
		}
		Page<Board> pageList = null;
		if(search != null) {
		pageList = boardService.getBoardList(pNum,searchn,search);
		}else {
		pageList = boardService.getBoardList(pNum);
		}
		List<Board> bList = pageList.getContent();// 보여질 글
		int totalPageCount = pageList.getTotalPages();// 전체 페이지 수
		long total = pageList.getTotalElements();
		m.addAttribute("blist", bList);
		m.addAttribute("totalPage", totalPageCount);
		m.addAttribute("total", total);
		System.err.println("total : "+total);
		int pageNum= 2;
		int begin = (pNum - 1) / pageNum * pageNum + 1;
		int end = begin + pageNum - 1;
		if (end > totalPageCount) {
			end = totalPageCount;
		}

		m.addAttribute("begin", begin);
		m.addAttribute("end", end);
		m.addAttribute("search", search);
		m.addAttribute("searchn", searchn);
		
		return "getBoardList";
	}

	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}

	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @ModelAttribute("host")Host host) {
		board.setWriter(host.getId());
		boardService.saveBoard(board);
		return "redirect:/getBoardList";
	}

	@RequestMapping("/content/{num}")
	public String getBoard(@PathVariable Long num, Model m) {
		Board board = boardService.getBoard(num);
		m.addAttribute("board", board);
		return "getBoard";
	}

	@GetMapping("/updateform/{num}")
	public String updateform(@PathVariable Long num, Model m) {
		Board board = boardService.onlyBoard(num);
		m.addAttribute("board", board);
		return "updateform";
	}

	@PostMapping("/update")
	public String update(Board board) {
		boardService.saveBoard(board);
		return "redirect:/getBoardList";
	}

	@GetMapping("/delete/{num}")
	public String delete(@PathVariable Long num) {
		boardService.deleteBoard(num);
		return "redirect:/getBoardList";
	}
}
