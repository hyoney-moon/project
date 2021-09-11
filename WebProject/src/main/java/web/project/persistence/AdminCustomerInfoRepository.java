package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.CustInfo;

public interface AdminCustomerInfoRepository extends JpaRepository<CustInfo, Long> {

}
