package web.project.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import web.project.domain.Qna;


@Configuration
public interface QnaService {

	List<Qna> getQnaList(Long num);

	void updateQnaList(Qna qna);
}
