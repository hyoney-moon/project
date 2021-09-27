package web.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Customer;
import web.project.persistence.CustomerRepository;

/**
 * 회원 관련 작업을 처리해 주는 메소드의 원형을 소유한 클래스
 * id 중복 검사를 위한 메소드 선언
 */

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer joinMember(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer loginCustomer(Customer customer) {
		Optional<Customer> findMember = customerRepository.findById(customer.getCustId());
		if (findMember.isPresent())
			return findMember.get();
		else
		return null;
	}

	@Override
	public Optional<Customer> findCustomer(String custId) {
		Optional<Customer> customer = customerRepository.findById(custId);
		return customer;
	}

	@Override
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}
	
	// 아이디 중복 검사를 위한 메소드
	@Override
	public Customer idcheck(String custId) {
		return customerRepository.findByCustId(custId);
	}
}
