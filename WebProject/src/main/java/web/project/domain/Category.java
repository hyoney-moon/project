package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String category;
	private String filePath;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
