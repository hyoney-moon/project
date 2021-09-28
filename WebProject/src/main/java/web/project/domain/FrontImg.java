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
@SequenceGenerator(name="FrontImg_Seq_Gen", sequenceName="FrontFile_Seq", initialValue=1, allocationSize=1)
public class FrontImg implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FrontImg_Seq_Gen")
	private Long frontImgNo;
	private Long boardNum;
	private String origFilename;
	private String filename;
	private String filePath;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="boardNum", insertable = false, updatable = false)
	private Board board;
	
//	이렇게하면 왜 안되는지 모르겠어...
//	@ManyToOne
//	@JoinColumn(name="boardNum", insertable = false, updatable = false)
//	private Board board;
	
//	@ManyToOne
//	@JoinColumn(name="boardNum", insertable = false, updatable = false)
//	private Board board;
	
	
}
