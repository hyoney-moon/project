package web.project.service;

import java.util.List;

import web.project.domain.FrontImg;

public interface FrontImgService {
	
	//대표이미지 저장
	FrontImg saveFrontImg(FrontImg frontImg);
	//대표이미지 메인에 보여줌
	List<FrontImg> viewImg(Long boardNum);
	
	List<FrontImg> viewList();
	
	

}
