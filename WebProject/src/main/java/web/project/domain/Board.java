package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;

@Entity
@SequenceGenerator(name="Board_Seq_Gen", sequenceName="Board_Seq", initialValue=1, allocationSize=1)
public class Board implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Board_Seq_Gen")
	private int num;
	private String host_id;
	private String spaceName;
	private String content_oneline;
	private String content;
	private String direction;
	private String caution;
	private String website;
	private String front_img;
	private String image;
	private String zipcode;
	private String address;
	private String address_detail;
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(insertable = false, updatable = false, columnDefinition = "number default 0")
	private int readcount;
	private int wishList;
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date regdate;
	private int price;
	private int headcnt;
	
	@ManyToOne
	@JoinColumn(name="big_category", insertable = false, updatable = false)
	private Category category;
	
	public String getHost_id() {
		return host_id;
	}
	public void setHost_id(String host_id) {
		this.host_id = host_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public String getContent_oneline() {
		return content_oneline;
	}
	public void setContent_oneline(String content_oneline) {
		this.content_oneline = content_oneline;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getCaution() {
		return caution;
	}
	public void setCaution(String caution) {
		this.caution = caution;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getFront_img() {
		return front_img;
	}
	public void setFront_img(String front_img) {
		this.front_img = front_img;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getWishList() {
		return wishList;
	}
	public void setWishList(int wishList) {
		this.wishList = wishList;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHeadcnt() {
		return headcnt;
	}
	public void setHeadcnt(int headcnt) {
		this.headcnt = headcnt;
	}
	
	@Override
	public String toString() {
		return "Board [num=" + num + ", host_id=" + host_id + ", spaceName=" + spaceName + ", content_oneline="
				+ content_oneline + ", content=" + content + ", direction=" + direction + ", caution=" + caution
				+ ", website=" + website + ", front_img=" + front_img + ", image=" + image + ", address=" + address
				+ ", readcount=" + readcount + ", wishList=" + wishList + ", regdate=" + regdate + ", price=" + price
				+ ", headcnt=" + headcnt + ", category=" + category + "]";
	}
}
