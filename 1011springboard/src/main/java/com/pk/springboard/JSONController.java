package com.pk.springboard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pk.springboard.service.UserService;

@RestController
public class JSONController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="user/idcheck",
			method = RequestMethod.GET)
	public Map<String, Object> idcheck(
			@RequestParam("email") String email,
			Model model){
		Map<String, Object> map = 
				new HashMap<String, Object>();
		String result = userService.idcheck(email);
		map.put("result", result == null);
		return map;
	}
}






