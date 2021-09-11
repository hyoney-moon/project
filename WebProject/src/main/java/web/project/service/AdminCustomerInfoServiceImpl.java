package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.CustInfo;
import web.project.persistence.AdminCustomerInfoRepository;

@Service
public class AdminCustomerInfoServiceImpl implements AdminCustomerInfoService {
	@Autowired
	private AdminCustomerInfoRepository adminCustomerInfo;

	@Override
	public List<CustInfo> CustInfo() {
		return adminCustomerInfo.findAll();
	}

}
