package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
// 

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
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date commentDate; // 댓글 작성 시간
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date replyDate; // 댓글 작성 시간
	private String content; // 댓글 작성 내용
	private String profile;
	//private String custId;
	private String nickName;
	private String hostContent;
	private String hostId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="boardNum")
	private Board board;
	
}
