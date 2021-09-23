package web.project.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * 요청을 받아 결과를 JSON 으로 리턴하고 ID 중복체크를 처리하는 메소드가 있는 class
 */
@RestController
public class JSONController {
	/*
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="member/idcheck",
			method = RequestMethod.GET)
	public Map<String, Object> idcheck(
			@RequestParam("custId") String custId,
			Model model)
			{
				Map<String, Object> map =
						new HashMap<String, Object>();
				String result = memberService.idcheck(custId);
				map.put("result", result == null);
				return map;
			}
	*/
}
