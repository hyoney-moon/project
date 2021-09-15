package web.project.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// 
/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Board implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private Long boardNum; // 글번호
	private String spaceName; // 공간명(글제목)
	private String contentOneline; // 공간 한줄 소개
	private String content; // 공간 소개(본문)
	private String caution; // 주의사항
	private String website; 
	private String readCount; // 조회수
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date regDate;
	private Long price;
	private String zipcode;
	private String address; // 공간 주소
	private String addressDetail;
	private String direction;
	@Column(columnDefinition = "number default 0")
	private Long permit;
}
