package web.project.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: Review
 *
 */
@Entity
@Getter
@Setter
public class Review implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long review_id;
	@GeneratedValue
	private Long boardNum;
	private String hostId, custId, review_content, review_img, review_anscon, review_answer;
	private int review_star;
	private String review_date;
	

	public String getReview_date() {
		return review_date.substring(0, 10);
	}
	public void setReview_date() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) +1;
		int day = cal.get(Calendar.DATE);
		this.review_date = year + "-" + month + "-" + day;
	}
   
}
