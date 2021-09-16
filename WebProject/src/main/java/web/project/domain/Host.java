package web.project.domain;

import java.io.Serializable; 
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Host implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	/* @Column(name = "HOSTID") */
	private String id; 
	private String password;
	private String nickname;
	private String email;
	private String gender;
	private String address;
	private String address_detail;
	private String zipcode;
	
}
