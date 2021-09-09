package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Host implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String hostid;
	private String password;
	private String email;
	private String nickname;
	private String gender;
	private String address;
	private String post;
	private String profile;
	
	
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
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
	
	

   
}
