package web.project.service;

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
}
