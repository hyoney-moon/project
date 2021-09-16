package web.project.service;

import java.util.Optional;


import web.project.domain.Customer;

public interface MemberService {
	
	// 회원가입
	Customer joinMember(Customer customer);
	
	// 로그인
	Customer loginCustomer(Customer customer);
	Optional<Customer> findCustomer(String CustId);
	
	// 회원 탈퇴
	void delete(Customer customer);

}
