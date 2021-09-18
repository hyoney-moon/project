package web.project.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import web.project.domain.Board;
import web.project.domain.CustQna;
import web.project.domain.Customer;
import web.project.domain.FrontImg;
import web.project.domain.Host;
import web.project.domain.HostQna;
import web.project.domain.Img;
import web.project.service.BoardService;
import web.project.service.FrontImgService;
import web.project.service.ImgService;
import web.project.service.QnaService;

@SessionAttributes("customer")
@Controller
@RequestMapping("/customer")
public class CustBoardController implements ApplicationContextAware {
	
	private WebApplicationContext context = null;
	
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
	
	@Autowired
	private FrontImgService frontImgService;
	@Autowired
	private ImgService imgService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private QnaService qnaService;
	
	//등록 된 공간 리스트
	@RequestMapping("/viewBoard")
	public String viewBoard(Model model,
			@RequestParam(name="p", defaultValue="1")int pNum, 
			@ModelAttribute("customer")Customer cust) {
		if(cust.getCustId() == null) {
			return "login/hostLoginForm";
		}
		Page<Board> pageList = boardService.getBoardList(pNum);
		List<Board> bList = pageList.getContent(); //보여질 글
		int totalCount = pageList.getTotalPages(); //전체 페이지 수
		model.addAttribute("bList", bList);
		model.addAttribute("totalCount", totalCount);
		
		int begin = (pNum-1)/5*5+1; //숫자 2 부분만 원하는 갯수로 바꿔주면 됨
		int end = begin+5-1;
		if(end>totalCount) {
			end = totalCount;
		}
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
			
		return "custmain/boardList";
	}
	
	//글 상세보기
	@RequestMapping("/viewPost/{boardNum}")
	public String viewPost(Model model, @PathVariable Long boardNum, FrontImg fi) {
		Board view = boardService.viewPost(boardNum);
		model.addAttribute("view",view);
		
		List<FrontImg> fis = frontImgService.viewImg(boardNum);
		model.addAttribute("fis", fis);
		model.addAttribute("fisize", fis.size());
		return "host_board/viewPost";
	}
	
	//게시판 검색
	@RequestMapping("/searchForm")
	public String searchForm() {
		return "search/searchForm";
	}
	@PostMapping("/searchBoard")
	public String searchBoard(Model model, @RequestParam(name="p", defaultValue="1")int pNum, 
			Board board, int search_option, String search) {
		Page<Board> searchList = boardService.searchBoardList(pNum, search_option, search);
		List<Board> boardList = searchList.getContent(); //보여질 글
		int totalCount = searchList.getTotalPages(); //전체 페이지 수
		long total = searchList.getTotalElements();
		
		model.addAttribute("boardList",boardList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("total", total);
		
		int begin = (pNum-1)/5*5+1;
		int end = begin+5-1;
		if(end>totalCount) {
			end = totalCount;
		}
		
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		model.addAttribute("search", search);
		model.addAttribute("search_option", search_option);
		
		return "search/searchForm";
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
	
	// 댓글 출력(ajax)
	@RequestMapping(value = "/comment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String commentList(Long boardNum) throws Exception {
		List<CustQna> custQnaResult = qnaService.getQnaList(boardNum);
		Gson json = new Gson();
		return json.toJson(custQnaResult);
	}
	
	@RequestMapping(value = "/replyComment", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String replyCommentList(Long boardNum) throws Exception {
		List<HostQna> hostQnaResult = qnaService.getHostQnaList(boardNum);
		Gson json = new Gson();
		return json.toJson(hostQnaResult);
	}
	
	//어플리케이션 객체 구함, realPath구하려고
	@Override
    public void setApplicationContext(ApplicationContext applicationContext)
          throws BeansException {
       this.context = (WebApplicationContext) applicationContext;
    }
	
}
