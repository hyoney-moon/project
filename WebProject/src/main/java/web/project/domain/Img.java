package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name="Img_Seq_Gen", sequenceName="Img_Seq", initialValue=1, allocationSize=1)
public class Img implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Img_Seq_Gen")
	private Long imgNo;
	private Long boardNum;
	private String origFilename;
	private String filename;
	private String filePath;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="boardNum", insertable = false, updatable = false)
	private Board board;
	
}
