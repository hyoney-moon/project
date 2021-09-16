package web.project.controller;

import java.util.Random; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.project.domain.EmailVO;
import web.project.service.EmailService;



@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping("/send")
	public String[] sendMail(String emailAddress) throws Exception {

		EmailVO email = new EmailVO();

		String receiver = emailAddress; // Receiver.

		String subject = "Email 제목";

		String number = makeRandom();
		
		String content = "인증 번호는 "+number+"입니다.";
		
		email.setReceiver(receiver);
		email.setSubject(subject);
		email.setContent(content);

		Boolean result = emailService.sendMail(email);

		return new String[] {number, result.toString()};

	}
	private String makeRandom() {
		Random r = new Random();
		String number = "";
		for(int i = 0;i < 6; i++) {
			number += r.nextInt(10);
		}
		System.out.println("number:"+number);
		return number;
	}

}