package web.project.service;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

	
	// 회원가입 메소드
	@Override
	public Customer joinMember(Customer customer) {
		return customerRepository.save(customer);
	}
	
	
	/*
	// 프로필 사진을 회원가입시 처리하는 메소드
	@Override
	public Customer joinMember(Customer customer) {
		// 파라미터 읽어오기
		// 파일은 getFile 로 읽고 MultipartFile 로 저장한다
		MultipartFile profile = request.getFile("profile");
		
		// 파일 업로드 처리
		// 업로드 할 디렉토리를 문자열로 생성
		String uploadPath = request.getRealPath("/profile");
		
		// 파일 이름 생성 - 중복을 피하기 위해 UUID 와 원본 파일을 합해서 생성
		UUID uuid = UUID.randomUUID();
		String filename = profile.getOriginalFilename();
		String filepath = uploadPath + "/" + uuid + "_" + filename;
		
		// 파일 업로드와 DB 작업
		Customer customer = new Customer();
		File file = new File(filepath);
		try {
			//
			customer.setProfile(uuid + "_" + filename);
			// 파일 업로드
			profile.transferTo(file);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return customerRepository.save(customer);
	}
	*/

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
	public String idcheck(String custId) {
		return customerRepository.idcheck(custId);
	}
	
}
