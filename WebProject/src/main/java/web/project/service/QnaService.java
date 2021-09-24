package web.project.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import web.project.domain.CustQna;


@Configuration
public interface QnaService {

	List<CustQna> getQnaList(Long boardNum);
	
	void insertCustQna(CustQna qna);
	
	void updateCustQna(String hostContent, Long qnaNum);


}
