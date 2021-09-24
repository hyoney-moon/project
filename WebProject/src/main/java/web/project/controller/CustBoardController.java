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
	
	// 게시글 목록
	@GetMapping("/searchForm")
	public String viewBoard(Model model,
			@RequestParam(name="p", defaultValue="1")int pNum, 
			@ModelAttribute("customer")Customer cust) {
		Page<Board> pageList = boardService.getCustBoardList(pNum);
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
		
		return "search/searchForm";
	}
	
	//글 상세보기
	@RequestMapping("/viewPost/{boardNum}")
	public String viewPost(Model model, @PathVariable Long boardNum, FrontImg fi) {
		Board view = boardService.viewPost(boardNum);
		model.addAttribute("view",view);
		
		List<FrontImg> fis = frontImgService.viewImg(boardNum);
		model.addAttribute("fis", fis);
		model.addAttribute("fisize", fis.size());
		return "cust_board/viewPost";
	}
	
	//검색기능 ajax
	@PostMapping("/searchBoard")
	@ResponseBody
	public String searchBoard(int search_option, String search) {
		List<Board> searchList = boardService.searchBoardList(search_option, search);
		System.out.println(search);
		Gson json = new Gson();
		return json.toJson(searchList);
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
	
	//이미지 뽑아오는 ajax
	@RequestMapping("/getImgs")
	@ResponseBody
	public String getImgs(Long boardNum) {
		List<FrontImg> imgList = frontImgService.viewImg(boardNum);
		Gson json = new Gson();
		return json.toJson(imgList);
	}
	//(검색)이미지 뽑아오는 ajax
		@RequestMapping("/getSearchImgs")
		@ResponseBody
		public String getSearchImgs(Long boardNum) {
			List<FrontImg> imgList = frontImgService.viewImg(boardNum);
			Gson json = new Gson();
			return json.toJson(imgList);
		}
	
	//어플리케이션 객체 구함, realPath구하려고
	@Override
    public void setApplicationContext(ApplicationContext applicationContext)
          throws BeansException {
       this.context = (WebApplicationContext) applicationContext;
    }
	
}
