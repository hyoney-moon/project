package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.FrontImg;
import web.project.domain.Img;
import web.project.persistence.ImgRepository;

@Service
public class ImgServiceImpl implements ImgService {
	
	@Autowired
	private ImgRepository imgRepo;
	
	@Override
	public Img saveImg(Img img) {
		return imgRepo.save(img);
	}
	
	@Override
	public List<Img> viewImg(Long boardNum) {
		return imgRepo.findByBoardNumOrderByImgNoDesc(boardNum);
	}

	@Override
	public List<Img> viewList() {
		return imgRepo.findAll();
	}
	
}
