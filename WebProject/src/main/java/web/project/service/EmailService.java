package web.project.service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.EmailVO;


@Service("emailService")
public class EmailService {

	@Autowired

	protected JavaMailSender mailSender;

	public boolean sendMail(EmailVO email) throws Exception {

		try {

			MimeMessage msg = mailSender.createMimeMessage();

			msg.setSubject(email.getSubject());

			// 일반 텍스트만 전송하려는 경우
			msg.setText(email.getContent());

			// HTML 컨텐츠를 전송하려면.
			//msg.setContent("<a href='https://www.naver.com/'>클릭</a>", "text/html;charset=utf-8");
			msg.setRecipient(RecipientType.TO, new InternetAddress(email.getReceiver()));//수신자 setting

			mailSender.send(msg);

			return true;

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		return false;

	}

}