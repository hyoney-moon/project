package web.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questions")
public class QnaResultController {

	@GetMapping("/QnaResult")
	public String getQnaResult() {
		return "host_board/qnaResult";
	}
	
	@PostMapping("/QnaResult")
	public String QnaResult() {
		return "host_board/qnaResult";
	}
	
	@GetMapping("/QnaForm")
	public String QnaForm() {
		return "host_board/questionForm";
	}
	
}
