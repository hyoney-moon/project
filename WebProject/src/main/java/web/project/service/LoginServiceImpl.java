package web.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Customer;
import web.project.persistence.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepo;
	
	@Override
	public Customer getCustomer(Customer customer) {
		Optional<Customer> findCustomer = loginRepo.findById(customer.getCust_id());
		if(findCustomer.isPresent())
			return findCustomer.get();
		else
			return null;
	}
}
