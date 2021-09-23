package web.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.persistence.AdminHostRepository;

@Service
public class AdminHostServiceImpl implements AdminHostService {

	
	@Autowired
	AdminHostRepository adHostRepo;
	
	@Override
	public List<Long> getHostCount(){
		long beforeJan = adHostRepo.countBeforeJan();
		long beforeFeb = adHostRepo.countBeforeFeb();
		long beforeMar = adHostRepo.countBeforeMar();
		long beforeApr = adHostRepo.countBeforeApr();
		long beforeMay = adHostRepo.countBeforeMay();
		long beforeJun = adHostRepo.countBeforeJun();
		long beforeJul = adHostRepo.countBeforeJul();
		long beforeAug = adHostRepo.countBeforeAug();
		long beforeSep = adHostRepo.countBeforeSep();
		
		List<Long> hostNumList = new ArrayList<>();
		hostNumList.add(beforeJan);
		hostNumList.add(beforeFeb);
		hostNumList.add(beforeMar);
		hostNumList.add(beforeApr);
		hostNumList.add(beforeMay);
		hostNumList.add(beforeJun);
		hostNumList.add(beforeJul);
		hostNumList.add(beforeAug);
		hostNumList.add(beforeSep);
		
		return hostNumList;
	}
	
//	@Override
//	public List<Long> getHostAge(){
//		long countAge10 = adHostRepo.countAge10();
//		long countAge20 = adHostRepo.countAge20();
//		long countAge30 = adHostRepo.countAge30();
//		long countAge40 = adHostRepo.countAge40();
//		long countAge50 = adHostRepo.countAge50();
//		
//		List<Long> hostAgeList = new ArrayList<>();
//		hostAgeList.add(countAge10);
//		hostAgeList.add(countAge20);
//		hostAgeList.add(countAge30);
//		hostAgeList.add(countAge40);
//		hostAgeList.add(countAge50);
//		
//		return hostAgeList;
//		
//	}
}
