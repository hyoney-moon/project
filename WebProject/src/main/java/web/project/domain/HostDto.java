package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: HostDto
 *
 */
@Getter
@Setter
@Entity
@Table(name = "host")

public class HostDto implements Serializable {

	@Id
	@Column(name = "hostId")
	private String hostId;
	private String password;
	private String email;
	private String nickname;
	private Character gender;
	private String address;
	private String post;
	private String profile;
	
	public HostDto() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

   
}
