package web.project.service;

import org.springframework.context.annotation.Configuration;

import web.project.domain.Customer;

@Configuration
public interface LoginService {

	Customer getCustomer(Customer customer);
}
