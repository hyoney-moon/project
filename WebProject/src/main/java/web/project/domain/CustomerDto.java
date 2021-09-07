package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: customerDto
 *
 */
@Entity
@Table(name = "customer")

public class CustomerDto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cust_id")
	private String cust_id;
	private String password;
	private String nickname;
	private Character gender;
	private int age;
	private String address;
	private String post;
	private int cash;
	private String profile;
	private String pick;
	
	
	
	@Override
	public String toString() {
		return "customerDto [cust_id=" + cust_id + ", password=" + password + ", nickname=" + nickname + ", gender="
				+ gender + ", age=" + age + ", address=" + address + ", post=" + post + ", cash=" + cash + ", profile="
				+ profile + ", pick=" + pick + ", getCust_id()=" + getCust_id() + ", getPassword()=" + getPassword()
				+ ", getNickname()=" + getNickname() + ", getGender()=" + getGender() + ", getAge()=" + getAge()
				+ ", getAddress()=" + getAddress() + ", getPost()=" + getPost() + ", getCash()=" + getCash()
				+ ", getProfile()=" + getProfile() + ", getPick()=" + getPick() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	public String getCust_id() {
		return cust_id;
	}


	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
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


	public Character getGender() {
		return gender;
	}


	public void setGender(Character gender) {
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


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public String getPick() {
		return pick;
	}


	public void setPick(String pick) {
		this.pick = pick;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public CustomerDto() {
		super();
	}
   
}
