package web.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="BOARD01")
@Setter
@Getter
@ToString
public class Board implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long num;
	private String title;
	@Column(updatable = false)
	private String writer;
	private String content;
	@Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
	private Date createDate;
	@Column(insertable = false, updatable = false, columnDefinition ="number default 0")
	private Long cnt;
	
	
	
	   
}
