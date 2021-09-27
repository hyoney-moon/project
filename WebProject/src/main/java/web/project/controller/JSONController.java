package web.project.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.project.domain.Customer;
import web.project.domain.Host;
import web.project.service.HostLoginService;
import web.project.service.MemberService;

/**
 * 클라이언트의 요청을 받아 결과를 JSON 으로 리턴하고 ID 중복체크를 처리하는 메소드가 있는 class
 */
@RestController
public class JSONController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private HostLoginService hostService;

	@RequestMapping(value = "/customer/idcheck", method = RequestMethod.GET)
	public Map<String, Object> idcheck(@RequestParam("custId") String custId, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		Customer result = memberService.idcheck(custId);
		if (result == null) {
			map.put("result", true);
		} else {
			map.put("result", false);
		}
		/* map.put("result", result == null); */
		return map;
	}
	
	@RequestMapping(value = "/host/idcheck", method = RequestMethod.GET)
	public Map<String, Object> hostIdcheck(@RequestParam("hostId") String hostId, Model model, Host host) {
		Map<String, Object> map = new HashMap<String, Object>();
		Optional<Host> result = hostService.findHostId(host.getHostId());
		//Optional로 꺼내오는 객체는 Null이 될 수 없기때문에 try-catch로 예외 발생시 true 리턴하도록 바꿔줌
		try {
		 Host h= result.get();	
		 map.put("result", false);
		}catch (NoSuchElementException e) {
			map.put("result", true);		
		}
		/* map.put("result", result == null); */
		return map;
	}
	

}
