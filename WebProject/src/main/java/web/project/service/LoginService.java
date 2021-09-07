package web.project.service;

import org.springframework.context.annotation.Configuration;

import web.project.domain.Customer;
import web.project.domain.Host;

@Configuration
public interface LoginService {

	Customer getCustomer(Customer customer);

	Host getHost(Host host);
}
