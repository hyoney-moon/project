package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
// 
/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@Setter
@Getter
public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String custId;
	private String email;
	private String password;
	private String nickName;
	private String gender;
	private Long age;
	private String post;
	private String cash; 
	private String profile;
	private String pick;
}
