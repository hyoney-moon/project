package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Qna;
import web.project.persistence.QnaRepository;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaRepository qnaRepo;
	
	@Override
	public List<Qna> getQnaList(Long boardNum) {
		return qnaRepo.getQnaList(boardNum);
	}
	
	@Override
	public void insertQna(Qna qna) {
		qnaRepo.save(qna);
	}
}
