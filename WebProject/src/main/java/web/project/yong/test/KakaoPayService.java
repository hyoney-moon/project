package web.project.yong.test;

import java.net.URI;
import java.net.URISyntaxException;
 

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;

 
 
@Service
public class KakaoPayService {

	private static final String HOST = "https://kapi.kakao.com";
	
	private RequestKakaoPay requestKakaoPay;

	private KakaoPayDto KakaoPayDto;
	
	public String KakaoPayReady() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","KakaoAk" + "4aad89620770c304945053debb56053b");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("partner_order_id", "1001");
		params.add("partner_user_id", "sol");
		params.add("item_name", "공간");
		params.add("quantity", "1");
		params.add("total_amount", "4500");
		params.add("tax_free_amount", "100");
		params.add("approval_url", "http://localhost:8088/kakaoPaySuccess");
		params.add("cancel_url", "http://localhost:8088/kakaoPayCancel");
		params.add("fail_user", "http://localhost:8088/kakaoPaySuccessFail");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params,headers);
				
				try{
					requestKakaoPay = restTemplate.postForObject(new URI(HOST + "v1/pament/ready"), body, requestKakaoPay.Class);
					
					log.info("" + requestKakaoPay);
					
							return requestKakaoPay.getNext_redirect_pc_url();
				}catch(RestClientException e) {
					e.printStackTrace();
				}catch (URISyntaxException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				return "/pay";
	}
	public KakaoPayDto kakaoPayInfo(String pg_token) {
		
		log.info("kakaoPayInfoDto..................");
		Log.info("---------------------");
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "kakaoAK" + "4aad89620770c304945053debb56053b");
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE );
		headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid","TC0ONETIME");
		params.add("tid", requestKakaoPay.getTid());
		params.add("partner_order_id", "1001");
		params.add("partner_user_id", "yong");
		params.add("pg_token", pg_token);
		params.add("total_amount", "4500");
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String,String>>(params,headers);
		
		try {
			KakaoPayDto = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayDto.class);
			log.info("" + KakaoPayDto);
			
			return KakaoPayDto;
		} catch(RestClientException e) {
			e.printStackTrace();
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
