package web.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.project.domain.Board;
import web.project.domain.Qna;
import web.project.service.BoardService;
import web.project.service.QnaService;

@Controller
@RequestMapping("/questions")
public class QnaResultController {
	@Autowired
	QnaService qnaser;
	@Autowired
	BoardService boardser;

	// 게시판 + QnA 화면 조회
	@GetMapping("/QnaResult")
	public String getQnaResult(Long boardNum, Model m) {
		Board BoardResult = boardser.getBoard(boardNum);
		List<Qna> QnaResult = qnaser.getQnaList(boardNum);
		m.addAttribute("qna", QnaResult);
		m.addAttribute("board", BoardResult);
		return "host_board/qnaResult";
	}
	
	// QnA 작성(일반회원)
	@PostMapping("/insertQna")
	public String insertQna(Qna qna) {
		qnaser.insertQna(qna);
		return "redirect:/qnaResult";
	}
	
}
