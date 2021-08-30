package web.project.yong.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Controller
public class KakaoPayController {

	@Setter(onMethod =  @Autowired)
	private KakaoPayService kakaopay;
	
	@GetMapping("/kakaopay")
	public String kakaoPay() {
		log.info("kakaopay post.......................");
		
		return "redirect:" + kakaopay.KakaoPayReady();
	}
	@GetMapping("/kakaoPaySuccess")
	public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
		log.info("kakaoPaySuccess get......................");
		log.info("kakaoPaySuccess pg_token : "+ pg_token);
		
		model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
	}
}
