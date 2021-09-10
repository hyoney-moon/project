package web.project.domain;

import java.io.Serializable;
import javax.persistence.*;

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
	
	@ManyToOne
	@JoinColumn(name="boardNum", insertable = false, updatable = false)
	private Board board;
	
	
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Long getImgNo() {
		return imgNo;
	}
	public void setImgNo(Long imgNo) {
		this.imgNo = imgNo;
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
