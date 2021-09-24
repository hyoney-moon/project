package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
// 
/**
 * Entity implementation class for Entity: Host
 *
 */
@Entity
@Getter
@Setter
public class Host implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String hostId;
	private String password;
	private String email;
	private String nickName;
	private String gender;
	private String profile;
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date joinDate;
	
}
