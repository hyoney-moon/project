package web.project.review;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.review.ReviewDto;
import web.project.review.ReviewRepository;

@Service
public class ReviewImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository ReviewRepo;

	@Override
	public List<ReviewDto> selectReview(ReviewDto dto) {
		/* return ReviewRepo.selectReview(dto.getnum()); */
		 return ReviewRepo.selectReview(dto.getboardNum()); 
	}

	@Override
	public List<ReviewDto> selectReviewOrderbyLikes(ReviewDto dto) {
		return ReviewRepo.selectReviewOrderbyLikes(dto.getboardNum());
	}

	@Override
	public List<ReviewDto> selectReviewOrderbyUserId(ReviewDto dto) {
		return ReviewRepo.selectReviewOrderbyUserId(dto.getboardNum(), dto.getCust_id());
	}

	@Override
	public ReviewDto insertReview(ReviewDto dto) {
		return ReviewRepo.save(dto);
	}

	@Override
	public ReviewDto reviewUpdate(ReviewDto dto) {
		return ReviewRepo.save(dto);
	}
	
	@Override
	public void deleteReview(int review_id) {
		ReviewRepo.deleteById(review_id);
	}

	@Override
	public int currentReview_id() {
		return 0;
	}

	@Override
	public String currentReview_asc(ReviewDto dto) {
		return null;
	}

	@Override
	public int currentReview_answer() {
		return 0;
	}

	@Override
	public ArrayList<LikesDto> countLikes(int review_id) {
		return null;
	}

	@Override
	public void updateLikes(ReviewDto dto) {
		
	}

	@Override
	public void viewCount(int review_id) {
		
	}

	@Override
	public String selectLikes(LikesDto dto) {
		return null;
	}

	@Override
	public void insertLikes(LikesDto dto) {
		
	}

	@Override
	public void deleteLikes(LikesDto dto) {
		
	}

	@Override
	public void likesUpdate(int review_id) {
		
	}

	@Override
	public void unLikesUpdate(int review_id) {
		
	}

	@Override
	public List<ReviewDto> getReview() {
		List<ReviewDto> review = ReviewRepo.findAll();
		return review;
	}
}
	
