package web.project.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity implementation class for Entity: PreBoard
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PreBoard implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long boardNum; // 글번호
	private String spaceName; // 공간명(글제목)
	private String contentOneline; // 공간 한줄 소개
	private String content; // 공간 소개(본문)
	private String direction; 
	private String caution; // 주의사항
	private String website; 
	private String frontImg; // 공간 이미지
	private String address; // 공간 주소
	private String readCount; // 조회수
	@Temporal(value = TemporalType.DATE)
	//@Column(columnDefinition = "date default sysdate")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E, dd MMM yyyy HH:mm:ss z", timezone = "GMT+2")
	//@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date regDate;
	private Long price;
	private Long headCount; 
	private String category;
}
