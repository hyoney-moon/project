package web.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.project.service.MemberService;

/**
 * 요청을 받아 결과를 JSON 으로 리턴하고 ID 중복체크를 처리하는 메소드가 있는 class
 */
@RestController
public class JSONController {
//	@Autowired
//	private MemberService memberService;
//	
//	@RequestMapping(value="member/idcheck",
//			method = RequestMethod.GET)
//	public Map<String, Object> idcheck(
//			@RequestParam("cust_id") String cust_id,
//			Model model)
//			{
//				Map<String, Object> map =
//						new HashMap<String, Object>();
//				String result = memberService.idcheck(cust_id);
//				map.put("result", result == null);
//				return map;
//			}
	
}
