package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.CustQna;
import web.project.domain.HostQna;
import web.project.persistence.HostQnaRepository;
import web.project.persistence.QnaRepository;
//
@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaRepository qnaRepo;
	@Autowired
	private HostQnaRepository hostQnaRepo;
	
	
	@Override
	public List<CustQna> getQnaList(Long boardNum) {
		return qnaRepo.getQnaList(boardNum);
	}
	
	@Override
	public List<HostQna> getHostQnaList(Long boardNum) {
		return hostQnaRepo.getHostQnaList(boardNum);
	}
	
	@Override
	public void insertCustQna(CustQna qna) {
		qnaRepo.save(qna);
	}
	
	@Override
	public void insertHostQna(HostQna qna) {
		hostQnaRepo.save(qna);
	}
}
