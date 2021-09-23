package web.project.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import web.project.domain.Customer;

public interface MemberService {
	
	// 회원가입
	Customer joinMember(Customer customer);
	
	// 로그인
	Customer loginCustomer(Customer customer);
	Optional<Customer> findCustomer(String CustId);
	
	// 회원 탈퇴
	void delete(Customer customer);
	
	// 아이디 중복 검사
 //	public String idcheck(String custId);
	
	// 회원가입 시 이미지파일 전송할 수 있는 멀티파트리퀘스트
 //	public void registerCustomer(MultipartHttpServletRequest request);

}
