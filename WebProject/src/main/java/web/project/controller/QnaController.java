package web.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.project.domain.Board;
import web.project.domain.CustQna;
import web.project.domain.HostQna;
import web.project.service.BoardService;
import web.project.service.QnaService;

@Controller
@RequestMapping("/questions")
public class QnaController {
	@Autowired
	QnaService qnaService;
	@Autowired
	BoardService boardService;
	
	// 일반회원 질문작성
	@PostMapping(value = "/insertCustQna", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void insertCustQna(CustQna qna) {
		qnaService.insertCustQna(qna);
	}
	
	// 호스트 답변
	@PostMapping(value = "/insertHostQna", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void insertHostQna(HostQna qna) {
		qnaService.insertHostQna(qna);
	}
}
