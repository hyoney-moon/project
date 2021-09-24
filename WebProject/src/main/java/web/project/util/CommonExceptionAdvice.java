package web.project.util;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 설정한 패키지에서 발생시 이곳의 메서드가 처리 
@ControllerAdvice("web.project.controller")
// 어커런스 자동 생성
@Component
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception ex) {
		
		ModelAndView modelAndView = new ModelAndView();
		// 에러 페이지 경로
		modelAndView.setViewName("/error/error");
		modelAndView.addObject("exception", ex);
		
		return modelAndView;
	}
	
}
