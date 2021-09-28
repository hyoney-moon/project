package web.project.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import web.project.domain.Customer;
import web.project.domain.Host;
import web.project.domain.Review;
import web.project.service.BoardService;
import web.project.service.QnaService;
import web.project.service.ReviewService;

@SessionAttributes({"host","customer"})
@Controller
public class BoardController{
	
	
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
	private QnaService qnaService;
	// 테스트
	@Autowired
	private ReviewService inter;
	
	
	//리뷰
	private int totalReview;
	private int tenReview = 5; // 나중에 10으로 변경하기
	private int totalPage;
	private int reviewSize;
	
	private List<Review> setPage(List<Review> reviewList, int page) {
		ArrayList<Review> listForPage = new ArrayList<Review>();
		// 몇번째 페이지인지 확인 및 글 셋팅할 때 초기값으로 사용
		int setReviewSize = (page - 1) * tenReview;

		// 페이지에 글이 몇 개 들어가는지 체크 (마지막 페이지만 다름)
		if (tenReview <= reviewList.size() - setReviewSize)
			reviewSize = tenReview;
		else
			reviewSize = reviewList.size() - setReviewSize;

		// 보여줄 페이지의 글만 불러서 listForPage에 셋팅
		for (int i = 0; i < reviewSize; i++) {
			listForPage.add(i, reviewList.get(setReviewSize + i));
		}

		return listForPage;
	}

	// 총 페이지 수 얻기
	public int totalPage() {
		totalPage = totalReview / tenReview;
		// 자투리 페이지 연산 처리
		if (totalReview % tenReview > 0)
			totalPage += 1;
		return totalPage;
	}

	// GoodsDtail에서 리뷰 리스트 불러오기
	@RequestMapping("/viewPost/{boardNum}/reviewList")
	@ResponseBody
	public Map<String, Object> reviewList(@PathVariable("boardNum")Long boardNum,
										  @RequestParam("page")int page,
										  @RequestParam("howAsc")String howAsc,
										  HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("page", page);
		session.setAttribute("howAsc", howAsc);
		
		// 어떤 순서로 조회할지 확인
		List<Review> reviewList = null;
		Review dto = new Review();
		//String cust_id = (String) session.getAttribute("cust_id");
		//dto.setCust_id(cust_id);
		dto.setBoardNum(boardNum);
		System.out.println("howAsc : " + howAsc);
		System.out.println("test");
		// 어떤 순서로 조회할지 확인
		//if (howAsc.equals("recently"))
			//reviewList = inter.selectReview(dto);
		//else if (howAsc.equals("likes"))
			//reviewList = inter.selectReviewOrderbyLikes(dto);
		//else if (howAsc.equals("myReview"))
			//reviewList = inter.selectReviewOrderbyUserId(dto);

		List<Review> afterPageList = setPage(reviewList, page);
		totalReview = reviewList.size();
		List<Map<String, String>> dataList = setReview(afterPageList);

		int review_id = -1;

		if (session.getAttribute("review_id") != null)
			review_id = (int) session.getAttribute("review_id");

		Map<String, Object> datas = new HashMap<String, Object>();
		System.out.println(review_id);

		datas.put("datas", dataList);
		datas.put("page", page);
		datas.put("totalPage", totalPage());
		datas.put("review_id", review_id);
		
		return datas;
	}
	/*
	 * @ResponseBody public List<ReviewDto> getlist(Long boardnum,Model m) {
	 * List<ReviewDto> list = inter.getListNum(boardnum); Gson json = new Gson();
	 * m.addAttribute("reviewList",json.toJson(list)); return list;
	 * 
	 * }
	 */

	// 리스트 입력
	public List<Map<String, String>> setReview(List<Review> afterPageList) {
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Map<String, String> data = null;

		for (Review r : afterPageList) {
			data = new HashMap<String, String>();
			data.put("review_id", Long.toString(r.getReview_id()));
			data.put("review_content", r.getReview_content());
			data.put("cust_id", r.getCust_id());
			data.put("review_date", r.getReview_date());
			data.put("review_img", r.getReview_img());
			dataList.add(data);
		}

		return dataList;
	}

	// 조회수 증가
	@RequestMapping("/view_count")
	@ResponseBody
	public Map<String, Object> test01(@RequestParam("review_id") int id,
			HttpServletResponse response, HttpServletRequest request) {
	
		// 글 상세보기를 위함
		HttpSession session = request.getSession();
		session.setAttribute("review_id", id);

		Map<String, Object> data = new HashMap<String, Object>();
		int page = (int) session.getAttribute("page");
		String howAsc = (String) session.getAttribute("howAsc");
		data.put("page", page);
		data.put("howAsc", howAsc);

		return data;
	}

//	// 좋아요 버튼
//	@RequestMapping("clickLikes")
//	@ResponseBody
//	public Map<String, Object> likesButton(HttpServletRequest request, @RequestParam("review_id") int review_id) {
//
//		HttpSession session = request.getSession();
//		String cust_id = (String) session.getAttribute("cust_id");
//
//		LikesDto dto = new LikesDto();
//		dto.setReview_id(review_id);
//		dto.setCust_id(cust_id);
//
//		Map<String, Object> data = new HashMap<String, Object>();
//		String result = "";
//		if (cust_id == null) {
//			result = "fail";
//			data.put("result", result);
//			return data; // 로그인 후 추천해주세요
//		} else {
//			String already = inter.selectLikes(dto);
//			if (already == null) {
//				inter.insertLikes(dto);
//				inter.likesUpdate(review_id);
//				result = "like";
//
//			} else {
//				inter.deleteLikes(dto);
//				inter.unLikesUpdate(review_id);
//				result = "unlike";
//			}
//		}
//		int page = (int) session.getAttribute("page");
//		String howAsc = (String) session.getAttribute("howAsc");
//		data.put("result", result);
//		data.put("page", page);
//		data.put("howAsc", howAsc);
//		return data; // 좋아요 처리 완료
//	}

	@GetMapping("/delete/{review_id}")
	public String delete(@PathVariable int review_id) { 
		inter.deleteReview(review_id); 
	  return "redirect:/index";
	  }

}
