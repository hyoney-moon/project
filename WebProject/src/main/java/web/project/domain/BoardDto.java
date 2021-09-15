package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BoarderDto
 *
 */
@Entity
@Table(name = "BOARD")
public class BoardDto implements Serializable {
	
	@Id
	@Column(name = "num")
	private Integer num;
	private String title;
	private String content;
	private int readcount;
	private int wishlist;
	private Date regdate;
	private String image;
	private int price;
	private int headcnt;
	private String address;
	private String host_id;
	private String roomtype;
	
	
	/*
	 * @Override public String toString() { return "BoarderDto [num=" + num +
	 * ", title=" + title + ", content=" + content + ", readcount=" + readcount +
	 * ", wishlist=" + wishlist + ", regdate=" + regdate + ", image=" + image +
	 * ", price=" + price + ", headcnt=" + headcnt + ", address=" + address +
	 * ", host_id=" + host_id + ", roomtype=" + roomtype + "]"; }
	 */

	

	public String getTitle() {
		return title;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getWishlist() {
		return wishlist;
	}

	public void setWishlist(int wishlist) {
		this.wishlist = wishlist;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHost_id() {
		return host_id;
	}

	public void setHost_id(String host_id) {
		this.host_id = host_id;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public BoardDto() {
		super();
	}
   
}
