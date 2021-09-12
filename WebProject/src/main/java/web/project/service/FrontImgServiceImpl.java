package web.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.FrontImg;
import web.project.persistence.FrontImgRepository;

@Service
public class FrontImgServiceImpl implements FrontImgService {
	
	@Autowired
	private FrontImgRepository frontImgRepo;
	
	@Override
	public FrontImg saveFrontImg(FrontImg frontImg) {
		return frontImgRepo.save(frontImg);
	}
	
//	@Override
//	public List<FrontImg> getFImgList() {
//		return frontImgRepo.findByFrontImgNo();
//	}

}
