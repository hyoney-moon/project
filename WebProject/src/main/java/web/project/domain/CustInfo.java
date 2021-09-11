package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: CustInfo
 *
 */
@Entity
@Setter
@Getter
public class CustInfo implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private Long custInfoNum;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="custId")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="boardNum")
	private Board board;
	
}
