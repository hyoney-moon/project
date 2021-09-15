package web.project.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import web.project.domain.Member;

public interface MemberService {
	
	// 회원가입
	Member joinMember(Member member);
	
	// 로그인
	Member loginMember(Member member);
	
	Optional<Member> findMember(String id);
	
	/*
	// 아이디 중복 체크 메소드
		public String idcheck(String cust_id);
		Member idcheckMember(Member member);
	*/
	
	
	// 파일 업로드를 포함할 경우 MultipartHttpServletRequest 를 매개변수로 만든다
// 		public void register(MultipartHttpServletRequest request);
 	//	Member registerMember(Member member);
	
	
	/*
	//	로그인 처리 메소드
 		public Member login(HttpServletRequest request);
 		Member loginMember(Member member);
	*/
}
