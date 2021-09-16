package web.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="Board_Seq_Gen", sequenceName="Board_Seq", initialValue=1, allocationSize=1)
public class PreBoard implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Board_Seq_Gen")
	private Long boardNum;
	
	@ManyToOne
	@JoinColumn(name="hostid", insertable = false, updatable = false)
	private Host host;
	
	private String hostid;
	private String spaceName;
	private String contentOneline;
	private String content;
	private String direction;
	private String caution;
	private String website;
	private String zipcode;
	private String address;
	private String addressDetail;
	@Column(insertable = false, updatable = false, columnDefinition = "number default 0")
	private int readcount;
	private int wishList;
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date regdate;
	private int price;
	private int headcnt;
	private String category;
	private Long frontImgNo;
	private Long imgNo;
	
	@ManyToOne
	@JoinColumn(name="category", insertable = false, updatable = false)
	private Category categoryFk;
	
	@OneToMany(mappedBy = "preboard", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private List<FrontImg> frontimgList = new ArrayList<>();
	
	@OneToMany(mappedBy = "preboard", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private List<Img> imgList = new ArrayList<>();
	
	
	
	public Long getImgNo() {
		return imgNo;
	}
	public void setImgNo(Long imgNo) {
		this.imgNo = imgNo;
	}
	public Long getFrontImgNo() {
		return frontImgNo;
	}
	public void setFrontImgNo(Long frontImgNo) {
		this.frontImgNo = frontImgNo;
	}
	public List<FrontImg> getFrontimgList() {
		return frontimgList;
	}
	public void setFrontimgList(List<FrontImg> frontimgList) {
		this.frontimgList = frontimgList;
	}
	public List<Img> getImgList() {
		return imgList;
	}
	public void setImgList(List<Img> imgList) {
		this.imgList = imgList;
	}
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public Category getCategoryFk() {
		return categoryFk;
	}
	public void setCategoryFk(Category categoryFk) {
		this.categoryFk = categoryFk;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Host getHost() {
		return host;
	}
	public void setHost(Host host) {
		this.host = host;
	}
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public String getContentOneline() {
		return contentOneline;
	}
	public void setContentOneline(String contentOneline) {
		this.contentOneline = contentOneline;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	
}
