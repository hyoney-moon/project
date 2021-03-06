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
import web.project.domain.Booking;
import web.project.domain.Category;
import web.project.domain.FrontImg;
import web.project.domain.Host;
import web.project.domain.Img;
import web.project.domain.Review;
import web.project.service.BoardService;
import web.project.service.BookingService;
import web.project.service.CategoryService;
import web.project.service.FrontImgService;
import web.project.service.ImgService;
import web.project.service.ReviewService;

@SessionAttributes("host")
@Controller
@RequestMapping("/host")
public class HostBoardController implements ApplicationContextAware {
	
	private WebApplicationContext context = null;
	
	@ModelAttribute("host")
	public Host getHost() {
		return new Host();
	}
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private FrontImgService frontImgService;
	@Autowired
	private ImgService imgService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ReviewService inter;
	@Autowired
	BookingService service;
	
	//???????????????
	@GetMapping("/insertBoardForm")
	public String postBoard(Model model, Host host) {
		if(host.getHostId() == null) {
			return "host_main/hostLoginForm";
		}
		List<Category> cList = categoryService.selectCate();
		model.addAttribute("cList", cList);
		return "host_board/postBoard";
	}
	
	//??????????????????
	@PostMapping("/insertBoard")
	public String insertBoard(Model model, Board board, Long frontImgNo, @ModelAttribute("host")Host host, List<MultipartFile> frontImg, List<MultipartFile> image) {
		
//		????????? ????????? ????????????
		board.setHostId(host.getHostId());
//		??????
		Board b =  boardService.saveBoard(board);
		List<FrontImg> imgb = frontImgService.viewImg(frontImgNo);
		model.addAttribute("place", b);
		model.addAttribute("viewImg", imgb);
		
		//????????? ????????? ?????????
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
		
		//????????? ?????????
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
		return "redirect:hostmain";
	}
	
	//(?????????)?????? ???????????? ?????? ????????? ??????
	private String getImgPath(MultipartFile image) {
		
		String oriName = image.getOriginalFilename(); //?????? ??? ????????? ?????? ??????
		int index = oriName.lastIndexOf(".");
		String ext = oriName.substring(index+1); //?????? ?????? ????????? ?????? ??????
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
	
	//(??????????????????)?????? ???????????? ?????? ????????? ??????
	private String getFrontPath(MultipartFile frontImg) {
		
			String oriName = frontImg.getOriginalFilename(); //?????? ??? ????????? ?????? ??????
			int index = oriName.lastIndexOf(".");
			String ext = oriName.substring(index+1); //?????? ?????? ????????? ?????? ??????
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
	
	//???????????? ?????? ?????? ????????? ??????
		@RequestMapping("/viewBoard")
		public String viewBoard(Model model,
				@RequestParam(name="p", defaultValue="1")int pNum, 
				@ModelAttribute("host")Host host, String hostId, Long boardNum) {
			//????????? ???????????? ????????? ?????? ????????? ????????? ????????? ?????????
			if(host.getHostId() == null) {
				return "host_main/hostLoginForm";
			}
			//????????? ???????????? ??? ?????? ????????? ????????????(session??? ????????? hostId??? ???????????? ?????????)
			Page<Board> pageList = boardService.getHostBoardList(pNum, host.getHostId());
			List<Board> bList = pageList.getContent(); //????????? ???
			int totalCount = pageList.getTotalPages(); //?????? ????????? ???
			model.addAttribute("bList", bList);
			model.addAttribute("totalCount", totalCount);
			
			int begin = (pNum-1)/5*5+1; //?????? 2 ????????? ????????? ????????? ???????????? ???
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
			List<String> dateList = service.getListDate(boardNum);
			Gson json = new Gson();
			
			List<Review> result = inter.getReviewDto();
			model.addAttribute("reviewDto",result);
			
			model.addAttribute("dateList",json.toJson(dateList));
			Board view = boardService.viewPost(boardNum);
			model.addAttribute("view",view);
			
			List<Img> fis = imgService.viewImg(boardNum);
			model.addAttribute("fis", fis);
			model.addAttribute("fisize", fis.size());
			return "host_board/hostViewPost";
		}
		
		//????????? ??????
		@GetMapping("/modifyPost/{boardNum}")
		public String modifyPostForm(Model model, @ModelAttribute("host")Host host , @PathVariable Long boardNum) {
			System.out.println(boardNum);
			if(host.getHostId() == null) {
				return "host_main/hostLoginForm";
			}
			Board view = boardService.updateBoard(boardNum);
			model.addAttribute("view",view);
			
			List<Category> cList = categoryService.selectCate();
			model.addAttribute("cList", cList);
			return "host_board/modifyPostForm";
		}
		
		@PostMapping("/modifyPost")
		public String modifyPost(Model model, Board board, Long frontImgNo, @ModelAttribute("host")Host host, List<MultipartFile> frontImg, List<MultipartFile> image) {
//			????????? ????????? ????????????
			board.setHostId(host.getHostId());
			board.setBoardNum(board.getBoardNum());
//			??????
			Board b =  boardService.saveBoard(board);
			List<FrontImg> imgb = frontImgService.viewImg(frontImgNo);
			model.addAttribute("place", b);
			model.addAttribute("viewImg", imgb);
			System.out.println(b.getBoardNum());
			
			//????????? ????????? ?????????
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
			
			//????????? ?????????
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
			return "redirect:hostmain";
		}
		
		
	//????????? ???????????? ajax
	@RequestMapping("/getImgs")
	@ResponseBody
	public String getImgs(Long boardNum) {
		List<FrontImg> imgList = frontImgService.viewImg(boardNum);
		Gson json = new Gson();
		return json.toJson(imgList);
	}
	
	//????????? ??????
	@RequestMapping("/deletePost/{boardNum }")
	public void deletePost(Long BoardNum) {
		boardService.deleteById(BoardNum);
	}
	

	//?????????????????? ?????? ??????, realPath????????????
	@Override
    public void setApplicationContext(ApplicationContext applicationContext)
          throws BeansException {
       this.context = (WebApplicationContext) applicationContext;
    }
	
	@GetMapping("hostBookingList/{boardNum}")
	   public String BookingList(@PathVariable(name = "boardNum") Long boardNum, Model m) {
	      List<Booking> booking = service.getListBooking(boardNum);
	      System.out.println("booking.size():"+booking.size());
	      m.addAttribute("booking", booking);
	      return "host_board/hostBookPermit";
	   }
	
	@GetMapping("/bookPermit") 
	   public String bookPermitUpdate(Long bookNum) { 
	       service.permitUpdate(bookNum);
	      
	      /*
	       * String custId = bookcustId.getCustId(); Customer custPrice
	       * =custSerivce.getCustId(custId); int boardPrice = bookcustId.getPrice(); Long
	       * total = custPrice.getCash() - boardPrice;
	       */
	      
	      return "host_board/completePermit";
	      }
	   
	   @GetMapping("/bookReject")
	   public String bookRejectUpdate(Long bookNum) {
	      service.rejectUpdate(bookNum);
	      
	      return "host_board/completePermit";
	   }
	
	
}
