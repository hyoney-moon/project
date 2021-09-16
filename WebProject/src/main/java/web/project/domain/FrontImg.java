package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

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
	
	@ManyToOne
	@JoinColumn(name="boardNum", insertable = false, updatable = false)
	private PreBoard preboard;
	
	
	public PreBoard getPreboard() {
		return preboard;
	}
	public void setPreboard(PreBoard preboard) {
		this.preboard = preboard;
	}
	public Long getFrontImgNo() {
		return frontImgNo;
	}
	public void setFrontImgNo(Long frontImgNo) {
		this.frontImgNo = frontImgNo;
	}
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getOrigFilename() {
		return origFilename;
	}
	public void setOrigFilename(String origFilename) {
		this.origFilename = origFilename;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	
}
