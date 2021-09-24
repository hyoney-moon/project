package web.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 
/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name="Board_Seq_Gen", sequenceName="Board_Seq", initialValue=1, allocationSize=1)
public class Board implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Board_Seq_Gen")
	private Long boardNum;
	
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
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date regDate;
	private int price;
	private int headcnt;
	private String category;
	private Long frontImgNo;
	private Long imgNo;
	@Column(columnDefinition = "number default 0")
	private Long permit;
	
	@ManyToOne
	@JoinColumn(name="hostId", insertable = false, updatable = false)
	private Host host;
	
	@ManyToOne
	@JoinColumn(name="category", insertable = false, updatable = false)
	private Category categoryFk;
	
	//이렇게 하면 DB에 경로까지 저장 됨
//	@ManyToOne
//	@JoinColumn(name="frontImgNo", insertable = false, updatable = false)
//	private FrontImg frontimg;
//	@ManyToOne
//	@JoinColumn(name="imgNo", insertable = false, updatable = false)
//	private Img img;
	
}
