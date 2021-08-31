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
@Table(name="BOARD")
@Setter
@Getter
public class Board implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int number; // 글번호
	private String host_id;
	private String spaceName; // 공간명(글제목)
	private String content_oneline;
	private String content;
	private String direction;
	private String caution; 
	private String website;
	private String front_img;
	private String address;
	private String readcount; 
	private String wishlist;
	private Date regdate;
	private int price;
	private int headcnt; 
	private String big_category;
	private String small_category;
   
}
