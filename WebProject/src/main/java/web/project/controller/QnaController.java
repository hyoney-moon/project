package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import web.project.domain.CustQna;
import web.project.service.BoardService;
import web.project.service.QnaService;

// 
@Controller
@RequestMapping("/qna")
public class QnaController {
	@Autowired
	QnaService qnaService;
	@Autowired
	BoardService boardService;

	// 일반회원 댓글 출력(ajax)
	@RequestMapping(value = "/getQna", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String commentList(Long boardNum) throws Exception {
		List<CustQna> custQnaResult = qnaService.getQnaList(boardNum);
		System.out.print("custQnaResult : " + custQnaResult);
		Gson gson = new Gson();

		return gson.toJson(custQnaResult);
	}

	// 일반회원 질문작성
	@PostMapping(value = "/question", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void insertCustQna(CustQna qna) {
		qnaService.insertCustQna(qna);
	}

	// 호스트 답변
	@PostMapping(value = "/answer", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void updateCustQna(String hostContent, Long qnaNum) {
		qnaService.updateCustQna(hostContent, qnaNum);
	}
}
