package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.CustInfo;

public interface AdminCustomerInfo extends JpaRepository<CustInfo, Long> {

}
