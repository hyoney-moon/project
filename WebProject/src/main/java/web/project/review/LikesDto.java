package web.project.review;

import org.springframework.stereotype.Component;

@Component
public class LikesDto {
	private int likes_id, num, review_id;
	private String cust_id;
	
	
	public int getLikes_id() {
		return likes_id;
	}
	public void setLikes_id(int likes_id) {
		this.likes_id = likes_id;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	
	
}