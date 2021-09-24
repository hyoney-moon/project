package web.project.service;

import java.util.Optional;
import web.project.domain.Customer;

import web.project.domain.Customer;

public interface MemberService {
	
	
	// 회원가입
	Customer joinMember(Customer customer);
	
	// 회원가입 시 이미지파일 전송할 수 있는 멀티파트리퀘스트(미완성)
	/*
	Customer joinMember(MultipartHttpServletRequest request);
	*/
	
	// 로그인
	Customer loginCustomer(Customer customer);
	Optional<Customer> findCustomer(String CustId);
	
	// 회원 탈퇴
	void delete(Customer customer);
	
	// 아이디 중복 검사(미완성)
 	public String idcheck(String custId);
 

}
