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
import web.project.domain.PreBoard;
import web.project.service.BoardService;
import web.project.service.FrontImgService;
import web.project.service.ImgService;
import web.project.service.PreBoardService;
import web.project.service.QnaService;

@SessionAttributes({"host","customer"})
@Controller
public class BoardController implements ApplicationContextAware {
	
	private WebApplicationContext context = null;
	
	@ModelAttribute("host")
	public Host getHost() {
		return new Host();
	}
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private FrontImgService frontImgService;
	@Autowired
	private ImgService imgService;
	@Autowired
	private QnaService qnaService;
	
	@PostMapping("/boardList")
	public String insertBoard(Model model, PreBoard board, Long frontImgNo, @ModelAttribute("host")Host host, List<MultipartFile> frontImg, List<MultipartFile> image) {
		board.setHostId(host.getHostId());
		PreBoard b =  boardService.saveBoard(board);
		List<FrontImg> imgb = frontImgService.viewImg(frontImgNo);
		System.out.println(b.getBoardNum());
		model.addAttribute("place", b);
		model.addAttribute("viewImg",imgb);
		
		//프론트 이미지 업로드
		for (MultipartFile file : frontImg) {
		String path = getFrontPath(file);
		FrontImg fi = new FrontImg();
		fi.setBoardNum(b.getBoardNum());
		fi.setFilename(path);
		fi.setFilePath(path);
		fi.setOrigFilename(file.getOriginalFilename());
		
		//save
		frontImgService.saveFrontImg(fi);
		}
		
		//이미지 업로드
		for (MultipartFile file : image) {
		String path = getImgPath(file);
		Img im = new Img();
		im.setBoardNum(b.getBoardNum());
		im.setFilename(path);
		im.setFilePath(path);
		im.setOrigFilename(file.getOriginalFilename());
				
		//save
		imgService.saveImg(im);
		}
		
		return "redirect:/";
	}
	
	//(이미지)실제 업로드할 경로 만드는 부분
	private String getImgPath(MultipartFile image) {
		
		String oriName = image.getOriginalFilename(); //저장 된 파일의 원본 이름
		int index = oriName.lastIndexOf(".");
		String ext = oriName.substring(index+1); //파일 이름 겹치지 않게 지정
		Random r = new Random();
		String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;
	
		String path = context.getServletContext().getRealPath("img/Img/"+fileName); 
    
		try {
			image.transferTo(new File(path));
		}catch(IllegalStateException | IOException e){
			e.printStackTrace();
		}
		
		return "/img/Img/"+fileName;
	}
	
	//(프론트이미지)실제 업로드할 경로 만드는 부분
	private String getFrontPath(MultipartFile frontImg) {
		
			String oriName = frontImg.getOriginalFilename(); //저장 된 파일의 원본 이름
			int index = oriName.lastIndexOf(".");
			String ext = oriName.substring(index+1); //파일 이름 겹치지 않게 지정
			Random r = new Random();
			String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;
			
			String path = context.getServletContext().getRealPath("img/frontImg/"+fileName); 
			System.out.println(path);
			try {
				frontImg.transferTo(new File(path));
			}catch(IllegalStateException | IOException e){
				e.printStackTrace();
			}
			
        return "/img/frontImg/"+fileName;
     }
	
	//공간 보기
		@RequestMapping("/viewBoard")
		public String viewBoard(Model model,
				@RequestParam(name="p", defaultValue="1")int pNum, 
				@ModelAttribute("host")Host host) {
			if(host.getHostId() == null) {
				return "login/hostLoginForm";
			}
			Page<PreBoard> pageList = boardService.getBoardList(pNum);
			List<PreBoard> bList = pageList.getContent(); //보여질 글
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
			
			return "host_board/boardList";
		}
		
		@RequestMapping("/viewPost/{boardNum}")
		public String viewPost(Model model, @PathVariable Long boardNum, FrontImg fi) {
			PreBoard view = boardService.viewPost(boardNum);
			model.addAttribute("view",view);
			
			List<FrontImg> fis = frontImgService.viewImg(boardNum);
			model.addAttribute("fis", fis);
			model.addAttribute("fisize", fis.size());
			return "host_board/viewPost";
		}
	
	//게시판 검색
	@RequestMapping("/searchForm")
	public String searchBoard() {
//		List<PreBoard> searchList = preboardService.searchBoard
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
