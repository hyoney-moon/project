package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
@Setter
@Getter
public class Board implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BOARD_NUM")
	private int num; // 글번호
	
	private String spaceName; // 공간명(글제목)
	private String content_oneline;
	private String content;
	private String direction;
	private String caution; 
	private String website;
	private String front_img;
	private String address;
	private String readcount; 
	private Date regdate;
	private int price;
	private int headcnt; 
	private String big_category;
	private String small_category;
   
	
	@ManyToOne
	@JoinColumn(name="HOST_ID")
	private Host host;
}
