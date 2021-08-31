package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@Table(name="CUSTOMER")
@Setter
@Getter
public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String cust_id;
	private String email;
	private String password;
	private String nickname;
	private String gender;
	private int age;
	private String post;
	private String cash; 
	private String profile;
	private String pick;
   
}
