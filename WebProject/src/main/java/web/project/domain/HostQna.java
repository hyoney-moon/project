package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity implementation class for Entity: HostQna
 *
 */
@Entity
@Setter
@Getter
public class HostQna implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private Long reQnaNum; // 댓글 글번호
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(insertable = false, columnDefinition = "date default sysdate")
	private Date commentDate; // 댓글 작성 시간
	private String content; // 댓글 작성 내용
	private String profile;
	private String hostId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="boardNum")
	private Board board;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="qnaNum")
	private CustQna custQna;
   
}
