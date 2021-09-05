package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class CustQna implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long qnaNum; // 댓글 글번호
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(insertable = false, columnDefinition = "date default sysdate")
	private Date commentDate; // 댓글 작성 시간
	private String content; // 댓글 작성 내용
	private String profile;
	private String custId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="boardNum")
	private Board board;
	
}
