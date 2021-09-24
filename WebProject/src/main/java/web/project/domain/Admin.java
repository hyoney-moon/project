package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@Getter
@Setter
public class Admin implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String adminId;
	private String password;
}
