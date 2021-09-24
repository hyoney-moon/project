package web.project.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javassist.Loader.Simple;
import lombok.extern.java.Log;
import web.project.domain.BookInfo;
import web.project.domain.Customer;
import web.project.domain.KakaoPayReadyDto;
import web.project.persistence.BoardDtoRepository;
 
@Service
@Log
@SessionAttributes("customer")
public class KakaoPay {
 
    private static final String HOST = "https://kapi.kakao.com";
    
    private KakaoPayReadyDto kakaoPayReadyDto;

    BoardDtoRepository board;
    
    
    public String kakaoPayReady(Customer custId, BookInfo booking) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "4aad89620770c304945053debb56053b");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME"); // 카카오rest API요청 토큰
        params.add("partner_order_id", (String)booking.getHostId()); // 호스트아이디 
        params.add("partner_user_id", custId.getCustId()); //구매자명
        params.add("item_name", booking.getBoard().getSpaceName()); //상품명
        params.add("quantity", 1+"");//결제일
        params.add("total_amount", booking.getPrice()+"");//가격
        params.add("tax_free_amount", "100");// 수수료
        params.add("approval_url", "http://localhost:8088/kakaoPaySuccess?bookNum="+booking.getBookNum()); //성공페이지
        params.add("cancel_url", "http://localhost:8088/kakaoPayCancel"); //취소페이지
        params.add("fail_url", "http://localhost:8088/kakaoPaySuccessFail"); // 실패페이지
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
        	kakaoPayReadyDto = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyDto.class);
           
            log.info("" + kakaoPayReadyDto);
            
            return kakaoPayReadyDto.getNext_redirect_pc_url();
          
         // 데이터 sql문 저장 부분 추가하기
            
         //취소 되었을 때 보낼 페이지   
        } catch (RestClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        // 결제 실패시 보내질 페이지 
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return "/pay";
        
    }
    
}
