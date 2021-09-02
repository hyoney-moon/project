package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

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
	private Long boardNum; // 글번호
	private String spaceName; // 공간명(글제목)
	private String content_oneline;
	private String content;
	private String direction;
	private String caution; 
	private String website;
	private String front_img;
	private String address;
	private String readcount;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date regDate;
	private Long price;
	private Long headcnt; 
	private String big_category;
	private String small_category;
	
	@ManyToOne
	@JoinColumn(name="hostId")
	private Host host;
}
