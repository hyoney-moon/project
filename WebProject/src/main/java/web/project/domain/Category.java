package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int num;
	private String big_category;
	private String small_category;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBig_category() {
		return big_category;
	}

	public void setBig_category(String big_category) {
		this.big_category = big_category;
	}

	public String getSmall_category() {
		return small_category;
	}

	public void setSmall_category(String small_category) {
		this.small_category = small_category;
	}

}
