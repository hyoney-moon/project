package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: BoarderDto
 *
 */
@Getter
@Setter
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
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public BoardDto() {
		super();
	}
   
}
