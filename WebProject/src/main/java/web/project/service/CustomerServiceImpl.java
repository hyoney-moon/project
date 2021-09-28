package web.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Customer;
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

	@Override
	public List<Long> getCustAge() {
		long countAge10 = CustRepo.countAge10();
		long countAge20 = CustRepo.countAge20();
		long countAge30 = CustRepo.countAge30();
		long countAge40 = CustRepo.countAge40();
		long countAge50 = CustRepo.countAge50();
		
		List<Long> custAgeList = new ArrayList<>();
		custAgeList.add(countAge10);
		custAgeList.add(countAge20);
		custAgeList.add(countAge30);
		custAgeList.add(countAge40);
		custAgeList.add(countAge50);
		
		return custAgeList;
	}

	@Override
	public List<Long> getCustGender() {
		long countGenderM = CustRepo.countGenderM(); 
		long countGenderW = CustRepo.countGenderW();
		
//		long percentM = countGenderM / (countGenderM + countGenderW);
//		long percentW = countGenderW / (countGenderM + countGenderW);
		
		List<Long> countGenderList = new ArrayList<>();
		countGenderList.add(countGenderM);
		countGenderList.add(countGenderW);
		
		return countGenderList;
	}


	@Override
	public void priceUpdate(Long boardNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustId(String custId) {
		return CustRepo.findByCustId(custId);
	}
	
}
