package web.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.persistence.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository CustRepo;

	@Override
	public List<Long> getCustCount() {
		long beforeJan = CustRepo.countBeforeJan();
		long beforeFeb = CustRepo.countBeforeFeb();
		long beforeMar = CustRepo.countBeforeMar();
		long beforeApr = CustRepo.countBeforeApr();
		long beforeMay = CustRepo.countBeforeMay();
		long beforeJun = CustRepo.countBeforeJun();
		long beforeJul = CustRepo.countBeforeJul();
		long beforeAug = CustRepo.countBeforeAug();
		long beforeSep = CustRepo.countBeforeSep();
		
		List<Long> custNumList = new ArrayList<>();
		custNumList.add(beforeJan);
		custNumList.add(beforeFeb);
		custNumList.add(beforeMar);
		custNumList.add(beforeApr);
		custNumList.add(beforeMay);
		custNumList.add(beforeJun);
		custNumList.add(beforeJul);
		custNumList.add(beforeAug);
		custNumList.add(beforeSep);
		
		return custNumList;
	}
	
	

}
