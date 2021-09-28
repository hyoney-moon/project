package web.project.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import web.project.domain.Customer;

@Configuration
public interface CustomerService {

	Customer getCustId(String custId);
	
	void priceUpdate(Long boardNum);
	
	List<Long> getCustCount();
	
	List<Long> getCustAge();
	
	List<Long> getCustGender();
}
