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

import web.project.domain.Board;
import web.project.domain.Qna;
import web.project.service.BoardService;
import web.project.service.QnaService;

@Controller
@RequestMapping("/questions")
public class QnaController {
	@Autowired
	QnaService qnaser;
	@Autowired
	BoardService boardser;
	
	// 질문작성
	@PostMapping("/insertQna")
	public String insertQna(Qna qna) {
		qnaser.insertQna(qna);
		return "redirect:host_board/getBoard";
	}
}
