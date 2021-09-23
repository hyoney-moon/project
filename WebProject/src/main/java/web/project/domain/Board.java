package web.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
// 
/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
@Setter
@Getter
@SequenceGenerator(name="Board_Seq_Gen", sequenceName="Board_Seq", initialValue=1, allocationSize=1)
public class Board implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Board_Seq_Gen")
	private Long boardNum;
	
	@ManyToOne
	@JoinColumn(name="hostId", insertable = false, updatable = false)
	private Host host;
	
	private String hostId;
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
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date regDate;
	private int price;
	private int headcnt;
	private String category;
	private Long frontImgNo;
	private Long imgNo;
	
	@ManyToOne
	@JoinColumn(name="category", insertable = false, updatable = false)
	private Category categoryFk;
	
	//이렇게 하면 DB에 경로까지 저장 됨
	@ManyToOne
	@JoinColumn(name="frontImgNo", insertable = false, updatable = false)
	private FrontImg frontimg;
	@ManyToOne
	@JoinColumn(name="imgNo", insertable = false, updatable = false)
	private Img img;
	
	
//	@OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
//	private List<FrontImg> frontimgList = new ArrayList<>();
//	
//	@OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
//	private List<Img> imgList = new ArrayList<>();
	
}
