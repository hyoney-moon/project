package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: HostDto
 *
 */
@Entity
@Table(name = "host")

public class HostDto implements Serializable {

	@Id
	@Column(name = "host_id")
	private String host_id;
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
	
	public String getHost_id() {
		return host_id;
	}

	public void setHost_id(String host_id) {
		this.host_id = host_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

   
}
