package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

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
public class Book_infoDto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer book_num;	//primary key
	private String cust_id;		//customer foreignkey
	private String host_id;		//host	   foreignkey
	private Integer num;			//board    foreingkey
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private int people;
	private int price;
	private int permit;   //호스트가 예약 가능하게 true false 값 전달
	@ManyToOne
	@JoinColumn(name = "cust_id",insertable = false, updatable = false)
	private CustomerDto cust;
	@ManyToOne
	@JoinColumn(name = "host_id",insertable = false, updatable = false)
	private HostDto host;
	@ManyToOne
	@JoinColumn(name = "num",insertable = false, updatable = false)
	private BoardDto board;  

	
}
