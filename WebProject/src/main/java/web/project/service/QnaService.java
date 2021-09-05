package web.project.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import web.project.domain.CustQna;
import web.project.domain.HostQna;


@Configuration
public interface QnaService {

	List<CustQna> getQnaList(Long boardNum);

	void insertCustQna(CustQna qna);

	void insertHostQna(HostQna qna);

	List<HostQna> getHostQnaList(Long boardNum);

}
