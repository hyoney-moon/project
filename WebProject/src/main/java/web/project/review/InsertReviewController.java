package web.project.review;

import java.io.File;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import web.project.review.ReviewDto;
import web.project.review.ReviewService;

@Controller
public class InsertReviewController {

	@Autowired
	private ReviewService inter;

	// 리뷰 작성 페이지로 이동
	@RequestMapping(value = "insertReview", method = RequestMethod.GET)
	public String insertReviewForm(@RequestParam(value = "boardNum", required = false) String boardNum,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("boardNum", boardNum);
		HttpSession session = request.getSession();
		String cust_id = (String) session.getAttribute("cust_id");
		/*
		 * if(cust_id == null) {
		 * 
		 * return "redirect:/insertReview"; //return "redirect:/goods?boardNum=" +
		 * boardNum + "&log=x"; } else { if(RorQ.equals("review")) return
		 * "insertReviewForm"; else return "insertQnaForm";
		 */
		return "/insertReviewForm";
	}

	// 리뷰 작성
	@RequestMapping(value = "insertReview", method = RequestMethod.POST)
	public String insertReview(ReviewDto dto, HttpServletRequest request,
							   @RequestParam("review_file")MultipartFile file) throws Exception{
		//int boardNum =
		//ID,글번호 셋팅
		HttpSession session = request.getSession();
		String cust_id = (String) session.getAttribute("cust_id");
		dto.setboardNum(1);
		int boardNum = dto.getboardNum();
		String asc = inter.currentReview_asc(dto);
		dto.setCust_id(cust_id);
		if(asc == null)
			dto.setReview_asc(1);
		else
			dto.setReview_asc(Integer.parseInt(asc)+1);
		
		//파일 업로드
	    String root_path = request.getSession().getServletContext().getRealPath("resources/review_img");  
	    String attach_path = "/";
	    String FILE_PATH = root_path + attach_path;
	    System.out.println("제바바아아ㅏ라ㅏ라라라라ㅏ" + FILE_PATH);
		
		
		String orgName = file.getOriginalFilename();
		/*
		 * String fileName = dto.getboardNum() + "_" + dto.getReview_asc() + "_" +
		 * orgName;
		 */
		String fileName = dto.getboardNum() + "_" + dto.getReview_asc() + "_" +orgName;
		if(!orgName.isEmpty()) {
			file.transferTo(new File(FILE_PATH, fileName));
			dto.setReview_img("resources/review_img/" + fileName);
		}
		else {	}
		
		//결과 반환
		ReviewDto b = inter.insertReview(dto);
			if(b != null)
				/* return "redirect:/goods?boardNum=" + boardNum; */
				return "redirect:/review";

			//return "redirect:/review";
			else
				return "error";
	}
	
	@GetMapping("review")
	public String pagee(Model m){
		List<ReviewDto> reviewAll = inter.getReview();
		m.addAttribute("review",reviewAll);
		System.out.println(reviewAll);
		return "index";
	}
}