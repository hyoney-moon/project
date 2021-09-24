package web.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.project.domain.Review;
import web.project.persistence.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository ReviewRepo;
	
	

	@Override
	public List<Review> selectReview(Review dto) {
		/* return ReviewRepo.selectReview(dto.getnum()); */
		 return ReviewRepo.selectReview(dto.getBoardNum()); 
	}

	@Override
	public List<Review> selectReviewOrderbyLikes(Review dto) {
		return ReviewRepo.selectReviewOrderbyLikes(dto.getBoardNum());
	}

	@Override
	public List<Review> selectReviewOrderbyUserId(Review dto) {
		return ReviewRepo.selectReviewOrderbyUserId(dto.getBoardNum(), dto.getCust_id());
	}

	@Override
	public Review insertReview(Review dto) {
		return ReviewRepo.save(dto);
	}

	@Override
	public Review reviewUpdate(Review dto) {
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
	public String currentReview_asc(Review dto) {
		return null;
	}

	@Override
	public int currentReview_answer() {
		return 0;
	}

//	@Override
//	public ArrayList<LikesDto> countLikes(int review_id) {
//		return null;
//	}

	@Override
	public void updateLikes(Review dto) {
		
	}

	@Override
	public void viewCount(int review_id) {
		
	}

//	@Override
//	public String selectLikes(LikesDto dto) {
//		return null;
//	}
//
//	@Override
//	public void insertLikes(LikesDto dto) {
//		
//	}
//
//	@Override
//	public void deleteLikes(LikesDto dto) {
//		
//	}

	@Override
	public void likesUpdate(int review_id) {
		
	}

	@Override
	public void unLikesUpdate(int review_id) {
		
	}

	@Override
	public List<Review> getReview() {
		List<Review> review = ReviewRepo.findAll();
		return review;
	}


	@Override
	public Page<Review> getReviewList(int pNum) {
		Pageable page = PageRequest.of(pNum-1, 5);
		return ReviewRepo.findByOrderByBoardNumDesc(page);
	}


	@Override
	public List<Review> allList() {
		List<Review> list = ReviewRepo.findAll();
		return list;
	}


	@Override
	public List<Review> getReviewDto() {
		return ReviewRepo.findAll();
	}


}
	
