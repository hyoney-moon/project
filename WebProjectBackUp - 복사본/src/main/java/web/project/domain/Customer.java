package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

/**
 * member 의 데이터를 저장할 클래스
 */
@Entity
@Setter
@Getter
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String custId;
	private String email;
	private String password;
	private String nickName;
	private String gender;
	private int age;
	private String address;
	private String addressDetail;
	private String zipcode;
	private String cash;
	private String profile;
	private String pick;
	@Column(columnDefinition = "date default sysdate")
	private Date joinDate;
	
	
	
	public String getCustId() {
		return custId;
	}



	public void setCustId(String custId) {
		this.custId = custId;
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



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
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



	public Date getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}



	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", email=" + email + ", password=" + password + ", nickName=" + nickName
				+ ", gender=" + gender + ", age=" + age + ", address=" + address + ", addressDetail=" + addressDetail
				+ ", zipcode=" + zipcode + ", cash=" + cash + ", profile=" + profile + ", pick=" + pick + ", joinDate="
				+ joinDate + "]";
	}
	
	
	
	
	
	

}
