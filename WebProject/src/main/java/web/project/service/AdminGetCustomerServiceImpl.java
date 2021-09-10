package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Customer;
import web.project.persistence.AdminGetCustomerRepository;

@Service
public class AdminGetCustomerServiceImpl implements AdminGetCustomerService {
	@Autowired
	private AdminGetCustomerRepository adminGetCustomerRepository; 
	
	@Override
	public List<Customer> getCustomerInfo() {
		return adminGetCustomerRepository.findAll();
	}

}
