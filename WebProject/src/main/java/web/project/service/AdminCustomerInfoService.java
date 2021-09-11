package web.project.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import web.project.domain.CustInfo;

@Configuration
public interface AdminCustomerInfoService {

	List<CustInfo> CustInfo();
}
