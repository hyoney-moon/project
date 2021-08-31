package web.project.service;

import org.springframework.beans.factory.annotation.Autowired;

import web.project.persistence.QnaRepository;

public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaRepository qnaRepo;
	
	
}
