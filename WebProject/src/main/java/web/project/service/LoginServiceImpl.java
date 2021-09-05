package web.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Customer;
import web.project.domain.Host;
import web.project.persistence.HostLoginRepository;
import web.project.persistence.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepo;
	@Autowired
	private HostLoginRepository hostLoginRepo;
	
	// 일반회원 로그인
	@Override
	public Customer getCustomer(Customer customer) {
		Optional<Customer> findCustomer = loginRepo.findById(customer.getCustId());
		if(findCustomer.isPresent())
			return findCustomer.get();
		else
			return null;
	}
	
	// 호스트 로그인
	@Override
	public Host getHost(Host host) {
		Optional<Host> findHost = hostLoginRepo.findById(host.getHostId());
		if(findHost.isPresent())
			return findHost.get();
		else
			return null;
	}
}
