package web.project.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * member 의 데이터를 저장할 클래스
 */
@Entity
public class Member implements Serializable {
	
	/*
	private static final long serialVersionUID = 1L;
	@Id
	private String cust_id;
	private String email;
	private String password;
	private String nickname;
	private String image;
	private int gender;
	private int age;
	private String address;
	private String post;
	private String cash;
	private String profile;
	private String pick;
	*/
	
	@Id
	private String custId;
	private String email;
	private String password;
	private String nickName;
	private String image;
	private int gender;
	private int age;
	private String address;
	private String addressDetail;
	private String zipcode;
	private String cash;
	private String profile;
	private String pick;
	
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
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
	
	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
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
	
//	@Override
//	public String toString() {
//		return "MemberVO [cust_id=" + cust_id + ", email=" + email + ", password=" + password + ", nickname=" + nickname
//				+ ", image=" + image + ", gender=" + gender + ", age=" + age + ", address=" + address + ", post=" + post
//				+ ", cash=" + cash + ", profile=" + profile + ", pick=" + pick + "]";
//	}
	
	/*
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Member member = (Member) o;
		return cust_id.equals(member.cust_id) &&
				nickname.equals(member.nickname) &&
				email.equals(member.email) &&
				password.equals(member.password) &&
				profile.equals(member.profile);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cust_id, nickname, email, password);
	}
	*/
	

}
