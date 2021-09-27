package web.project.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import web.project.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
/*	@Transactional
	@Modifying*/
		
	//전체 리뷰 조회
	List<Review> findAll();
	//리뷰 조회 (최신순)
	@Query(value="select * from review where boardNum = :boardNum order by review_asc desc", nativeQuery=true )
	List<Review> selectReview(@Param("boardNum")Long boardNum);
	
	//리뷰 조회 (추천순)
	@Query(value="select * from review where boardNum = :boardNum order by likes_count desc", nativeQuery=true )
	List<Review> selectReviewOrderbyLikes(@Param("boardNum")Long boardNum);
	
	
	//리뷰 조회 (내가 쓴 글 보기)
	@Query(value="select * from review where boardNum = :boardNum and cust_id = :cust_id order by review_asc desc", nativeQuery=true )
	List<Review> selectReviewOrderbyUserId(@Param("boardNum")Long boardNum, @Param("cust_id")String cust_id);
	
	//조회수 업데이트
	
	@Transactional
	@Modifying
	@Query(value="update review set review_viewCount = review_viewCount + 1 where review_id = :review_id", nativeQuery=true )
	void viewCount(@Param("review_id")int review_id);
	
	//리뷰 추가
	@Query(value="insert into review (boardNum, cust_id, review_content, review_star, review_answer, review_date, review_img, likes_count) values(:boardNum, :cust_id, :review_title, :review_content, 0, :review_star, :review_isPrivate ,:review_asc, 0, now(), :review_img, 0)", nativeQuery=true )
	void insertReview(@Param("boardNum")int boardNum, @Param("cust_id")int cust_id, 
			@Param("review_title")String review_title, @Param("review_content")String review_content, 
			@Param("review_star")float review_star,
			@Param("review_asc")int review_asc, @Param("review_img")String review_img);
	
	
	//MaxReview_asc 조회
	@Query(value="select max(review_asc) from review where boardNum = :boardNum", nativeQuery=true )
	List<Review> MaxReview_asc(@Param("boardNum")int boardNum);
	
 	//좋아요 갯수 조회
//	@Query(value="select * from likes where review_id = :review_id", nativeQuery=true )
//	ArrayList<LikesDto> countLikes(@Param("review_id")int review_id);
	
	//좋아요 확인 
	@Query(value="select cust_id from likes where cust_id = :cust_id and review_id = :review_id", nativeQuery=true )
	String selectLikes(@Param("cust_id")int cust_id, @Param("review_id")int review_id);
	
	//좋아요 생성
	@Query(value="insert into likes (cust_id, review_id) values(:cust_id, :review_id)", nativeQuery=true )
	void insertLikes(@Param("cust_id")int cust_id, @Param("review_id")int review_id);
	
	//좋아요 삭제
	@Query(value="delete from likes where cust_id = :cust_id and review_id = :review_id", nativeQuery=true )
	void deleteLikes(@Param("cust_id")int cust_id, @Param("review_id")int review_id);
	
	//종아요 수 업데이트
	@Transactional
	@Modifying
	@Query(value="update review set likes_count = likes_count + 1 where review_id = :review_id", nativeQuery=true )
	void likesUpdate(@Param("review_id")int review_id);

	Page<Review> findByOrderByBoardNumDesc(Pageable page);

}
