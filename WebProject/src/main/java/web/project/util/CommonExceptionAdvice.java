//package web.project.util;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// * Controller 에서 발생하는 예외를 처리하기 위한 클래스
// */
//
//// 설정 된 패키지에서 예외가 발생할 시 이곳의 메소드가 처리한다
//@ControllerAdvice("web.project")
//
//// 어커런스 자동 생성
//@Component
//public class CommonExceptionAdvice {
//	@ExceptionHandler(Exception.class)
//	private ModelAndView errorModelAndView(Exception ex) {
//
//		ModelAndView modelAndView = new ModelAndView();
//		//에러 페이지 경로
//		modelAndView.setViewName("/error/error");
//		modelAndView.addObject("exception", ex);
//
//		return modelAndView;
//	}
//}
