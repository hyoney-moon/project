package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Qna implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QNA_NUM")
	@GeneratedValue
	private Long qna_num; // 댓글 글번호
	//private Long grp; // 댓글이 속한 댓글 번호
	//private Long grpl; // 댓글의 깊이
	//@Temporal(TemporalType.TIMESTAMP)
	//@Column(updatable = false, columnDefinition = "date default sysdate")
	private Date reg_date; // 댓글 작성 시간
	private String content; // 댓글 작성 내용
	private String profile;
	
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="BOARD_NUM")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="HOST_ID")
	private Host host;
   
}
