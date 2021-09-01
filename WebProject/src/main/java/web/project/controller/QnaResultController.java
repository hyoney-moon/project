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

	@PostMapping("/QnaResult")
	public String getQnaResult(Long num, Model m) {
		System.out.print(num);
		Board BoardResult = boardser.getBoard(num);
		List<Qna> QnaResult = qnaser.getQnaList(num);
		m.addAttribute("qna", QnaResult);
		m.addAttribute("board", BoardResult);
		return "host_board/qnaResult";
	}
	
	@GetMapping("/QnaForm")
	public String QnaForm() {
		return "host_board/questionForm";
	}
	
}
