package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String custid;
	private String email;
	private String password;
	private String nickname;
	private String gender;
	private int age;
	private String address;
	private String post;
	private int cash;
	private int profile;
	private String wish;
	
	
	
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getProfile() {
		return profile;
	}
	public void setProfile(int profile) {
		this.profile = profile;
	}
	public String getWish() {
		return wish;
	}
	public void setWish(String wish) {
		this.wish = wish;
	}
	
}
