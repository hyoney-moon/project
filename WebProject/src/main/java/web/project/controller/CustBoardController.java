package web.project.controller;


import java.util.List;

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

import com.google.gson.Gson;

import web.project.domain.Board;
import web.project.domain.Customer;
import web.project.domain.FrontImg;
import web.project.domain.Review;
import web.project.service.BoardService;
import web.project.service.BookingService;
import web.project.service.FrontImgService;
import web.project.service.ImgService;
import web.project.service.QnaService;
import web.project.service.ReviewService;

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
	@Autowired
	private ReviewService inter;
	@Autowired
	BookingService service;
	
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
		
		Board board =  service.getBoard(boardNum);
		
		model.addAttribute("board", board);
		//사용자가 받는 데이터값 유효성 검사 단계
		 List<String> dateList = service.getListDate(boardNum);
		Gson json = new Gson();
		
		model.addAttribute("dateList",json.toJson(dateList));
		
		Board view = boardService.viewPost(boardNum);
		model.addAttribute("view",view);
		
		List<Review> result = inter.getReviewDto();
		model.addAttribute("reviewDto",result);
		
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
