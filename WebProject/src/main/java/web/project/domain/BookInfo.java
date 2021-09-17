package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: Book_infoDto
 *
 */
@Entity
@Table(name = "BOOKING")
@Getter
@Setter
public class BookInfo implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long bookNum;	//primary key
	private Date endDate;
	private String custId;		//customer foreignkey
	private String hostId;		//host	   foreignkey
	private Long boardNum;			//board    foreingkey
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDate;
	private int people;
	private int price;
	private int permit;   //호스트가 예약 가능하게 true false 값 전달
	@ManyToOne
	@JoinColumn(name = "custId",insertable = false, updatable = false)
	private Customer cust;
	@ManyToOne
	@JoinColumn(name = "hostId",insertable = false, updatable = false)
	private Host host;
	@ManyToOne
	@JoinColumn(name = "boardNum",insertable = false, updatable = false)
	private Board board;  

	
}
