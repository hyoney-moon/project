package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String category;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
