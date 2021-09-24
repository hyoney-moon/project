package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.CustQna;
import web.project.persistence.QnaRepository;
//
@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaRepository qnaRepo;
	
	
	@Override
	public List<CustQna> getQnaList(Long boardNum) {
		System.out.print("확인" + boardNum);
		return qnaRepo.getQnaList(boardNum);
	}
	
	@Override
	public void insertCustQna(CustQna qna) {
		qnaRepo.save(qna);
	}

	@Override
	public void updateCustQna(String hostContent, Long qnaNum) {
		qnaRepo.updateCustQna(hostContent, qnaNum);
	}
	

}
