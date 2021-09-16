package web.project.service;

import javax.mail.internet.MimeMessage;

public interface JavaMailSender {

	MimeMessage createMimeMessage();

	void send(MimeMessage msg);


}
