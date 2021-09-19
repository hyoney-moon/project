package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Integer bookNum;	//primary key
	private String custId;		//customer foreignkey
	private String hostId;		//host	   foreignkey
	private int boardNum;			//board    foreingkey
	private Date regDate;
	private int people;
	private int price;
	
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