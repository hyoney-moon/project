package web.project.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import web.project.domain.Customer;

@Configuration
public interface AdminGetCustomerService {

	List<Customer> getCustomerInfo();
}
