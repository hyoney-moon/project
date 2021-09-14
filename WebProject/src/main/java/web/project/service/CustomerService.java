package web.project.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public interface CustomerService {

	List<Long> getCustCount();
	
	List<Long> getCustAge();
	
	List<Long> getCustGender();
}
