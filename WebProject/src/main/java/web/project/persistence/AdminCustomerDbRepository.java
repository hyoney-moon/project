package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Customer;

public interface AdminCustomerDbRepository extends JpaRepository<Customer, Long> {

}
