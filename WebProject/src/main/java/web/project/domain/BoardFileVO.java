package web.project.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardFileVO {
	
	private String hostid;
	private String spcaeName;
	private List<MultipartFile> frontImg;
	private List<MultipartFile> Img;

}
