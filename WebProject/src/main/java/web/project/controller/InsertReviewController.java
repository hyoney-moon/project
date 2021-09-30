package web.project.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import web.project.domain.Review;
import web.project.service.ReviewService;

@SessionAttributes("customer")
@Controller
//@RequestMapping("/viewPost")
public class InsertReviewController {

	@Autowired
	private ReviewService inter;

	// 리뷰 작성 페이지로 이동
	@RequestMapping(value = "/insertReview/{boardNum}", method = RequestMethod.GET)
	public String insertReviewForm(@PathVariable Long boardNum,
			HttpServletRequest request, HttpServletResponse response, Model m) throws Exception {

		m.addAttribute("boardNum", boardNum);
		HttpSession session = request.getSession();
		
		String custId = (String) session.getAttribute("custId");
		/*
		 * if(cust_id == null) {
		 * 
		 * return "redirect:/insertReview"; //return "redirect:/goods?boardNum=" +
		 * boardNum + "&log=x"; } else { if(RorQ.equals("review")) return
		 * "insertReviewForm"; else return "insertQnaForm";
		 */
		return "cust_board/insertReviewForm";
	}

	// 리뷰 작성
	@RequestMapping(value = "insertReview", method = RequestMethod.POST)
	//@PostMapping("/insertReview/{boardnum}")
	public String insertReview(Review dto, HttpServletRequest request,
							   @RequestParam("review_file")MultipartFile file,
							   Long boardNum, Review review) throws Exception{
		//int boardNum =
		//ID,글번호 셋팅
//		HttpSession session = request.getSession();
//		String custId = (String) session.getAttribute("custId");
//		String asc = inter.currentReview_asc(dto);
//		dto.setCustId(custId);
		
		//파일 업로드
	    String root_path = request.getSession().getServletContext().getRealPath("/img/review_img");  
	    String attach_path = "/";
	    String FILE_PATH = root_path + attach_path;
	    System.out.println("제바바아아ㅏ라ㅏ라라라라ㅏ" + FILE_PATH);
		
		
		String orgName = file.getOriginalFilename();
		/*
		 * String fileName = dto.getboardNum() + "_" + dto.getReview_asc() + "_" +
		 * orgName;
		 */
		String fileName = dto.getBoardNum() + "_" + orgName;
		if(!orgName.isEmpty()) {
			file.transferTo(new File(FILE_PATH, fileName));
			dto.setReview_img("/img/review_img/" + fileName);
		}
		else {	}
		
		//결과 반환
		Review b = inter.insertReview(dto);
			if(b != null)
				//return "redirect:/viewPost/"+boardNum;
				return "redirect:/customer/viewPost/"+boardNum;

			//return "redirect:/review";
			else
				return "redirect:/customer/viewPost/"+boardNum;
	}
	
}