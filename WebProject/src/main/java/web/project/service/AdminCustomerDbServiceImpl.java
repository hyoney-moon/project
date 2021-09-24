package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Customer;
import web.project.persistence.AdminCustomerDbRepository;

@Service
public class AdminCustomerDbServiceImpl implements AdminCustomerDbService {
	@Autowired
	private AdminCustomerDbRepository adminGetCustomerRepository; 
	
	@Override
	public List<Customer> getCustomerInfo() {
		return adminGetCustomerRepository.findAll();
	}

}
