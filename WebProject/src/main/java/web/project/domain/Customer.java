package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

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
@DynamicInsert
public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String custId;
	private String email;
	private String password;
	private String nickName;
	private String gender;
	private Long age;
	private String zipcode;
	private String address;
	private String addressDetail;
	@Column(columnDefinition = "number default 100000")
	private Long cash;
	private String profile;
	//private String pick;
	@Column(columnDefinition = "number default 0")
	private Long totalSpend;
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date joinDate;

}
