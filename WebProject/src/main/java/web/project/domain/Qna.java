package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="QNA")
@Setter
@Getter
public class Qna implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long num; // 댓글 글번호
	private Long grp; // 댓글이 속한 댓글 번호
	private Long grpl; // 댓글의 깊이
	private Date date; // 댓글 작성 시간
	private String content; // 댓글 작성 내용
	
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	@JoinColumn(name="number")
	private Board board;
   
}
