package web.project.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.CookieGenerator;

import web.project.review.LikesDto;
import web.project.review.ReviewDto;
import web.project.review.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService inter;

	private int totalReview;
	private int tenReview = 5; // 나중에 10으로 변경하기
	private int totalPage;
	private int reviewSize;

	// 페이징 처리
	private List<ReviewDto> setPage(List<ReviewDto> reviewList, int page) {
		ArrayList<ReviewDto> listForPage = new ArrayList<ReviewDto>();
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
	@RequestMapping(value = { "review", "qna" })
	@ResponseBody
	public Map<String, Object> reviewList(@RequestParam("boardNum") int boardNum, @RequestParam("page") int page,
			@RequestParam("howAsc") String howAsc, @RequestParam("RorQ") String review_orQna,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("page", page);
		session.setAttribute("howAsc", howAsc);

		// 어떤 순서로 조회할지 확인
		List<ReviewDto> reviewList = null;
		ReviewDto dto = new ReviewDto();
		String cust_id = (String) session.getAttribute("cust_id");
		dto.setCust_id(cust_id);
		dto.setboardNum(boardNum);
		System.out.println("howAsc : " + howAsc);
		System.out.println("test");
		// 어떤 순서로 조회할지 확인
		if (howAsc.equals("recently"))
			reviewList = inter.selectReview(dto);
		else if (howAsc.equals("likes"))
			reviewList = inter.selectReviewOrderbyLikes(dto);
		else if (howAsc.equals("myReview"))
			reviewList = inter.selectReviewOrderbyUserId(dto);

		List<ReviewDto> afterPageList = setPage(reviewList, page);
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

	// 리스트 입력
	public List<Map<String, String>> setReview(List<ReviewDto> afterPageList) {
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		Map<String, String> data = null;

		for (ReviewDto r : afterPageList) {
			data = new HashMap<String, String>();
			data.put("review_id", Integer.toString(r.getReview_id()));
			data.put("review_asc", Integer.toString(r.getReview_asc()));
			data.put("review_title", r.getReview_title());
			data.put("review_content", r.getReview_content());
			data.put("cust_id", r.getCust_id());
			data.put("review_date", r.getReview_date());
			data.put("likes_count", Integer.toString(r.getLikes_count()));
			data.put("review_viewCount", Integer.toString(r.getReview_viewCount()));
			data.put("review_img", r.getReview_img());
			data.put("review_isPrivate", Integer.toString(r.getReview_isPrivate()));
			dataList.add(data);
		}

		return dataList;
	}

	// 조회수 증가
	@RequestMapping("view_count")
	@ResponseBody
	public Map<String, Object> test01(@RequestParam("review_id") String id, @CookieValue(name = "view") String cookie,
			HttpServletResponse response, HttpServletRequest request) {
		int x = id.indexOf("_");
		System.out.println("id");
		int review_id = Integer.parseInt(id.substring(0, x));

		if (!(cookie.contains(String.valueOf(review_id)))) {
			cookie += review_id + "/";
			inter.viewCount(review_id);
		}

		CookieGenerator cg = new CookieGenerator();
		cg.setCookieName("view");
		cg.setCookieMaxAge(60 * 60 * 24 * 365);
		cg.addCookie(response, cookie);

		// 글 상세보기를 위함
		HttpSession session = request.getSession();
		session.setAttribute("review_id", review_id);

		Map<String, Object> data = new HashMap<String, Object>();
		int page = (int) session.getAttribute("page");
		String howAsc = (String) session.getAttribute("howAsc");
		data.put("page", page);
		data.put("howAsc", howAsc);

		return data;
	}

	// 좋아요 버튼
	@RequestMapping("clickLikes")
	@ResponseBody
	public Map<String, Object> likesButton(HttpServletRequest request, @RequestParam("review_id") String id) {

		HttpSession session = request.getSession();
		String cust_id = (String) session.getAttribute("cust_id");
		int x = id.indexOf("_");
		int review_id = Integer.parseInt(id.substring(0, x));

		LikesDto dto = new LikesDto();
		dto.setReview_id(review_id);
		dto.setCust_id(cust_id);

		Map<String, Object> data = new HashMap<String, Object>();
		String result = "";
		if (cust_id == null) {
			result = "fail";
			data.put("result", result);
			return data; // 로그인 후 추천해주세요
		} else {
			String already = inter.selectLikes(dto);
			if (already == null) {
				inter.insertLikes(dto);
				inter.likesUpdate(review_id);
				result = "like";

			} else {
				inter.deleteLikes(dto);
				inter.unLikesUpdate(review_id);
				result = "unlike";
			}
		}
		int page = (int) session.getAttribute("page");
		String howAsc = (String) session.getAttribute("howAsc");
		data.put("result", result);
		data.put("page", page);
		data.put("howAsc", howAsc);
		return data; // 좋아요 처리 완료
	}

	@GetMapping("/delete/{review_id}")
	public String delete(@PathVariable int review_id) { 
		inter.deleteReview(review_id); 
	  return "redirect:/index";
	  }
	
}