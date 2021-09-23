package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Host;
import web.project.persistence.AdminHostInfoRepository;

@Service
public class AdminGetHostServiceImpl implements AdminGetHostService {
	
	@Autowired
	private AdminHostInfoRepository adminHostInfo;
	
	@Override
	public List<Host> hostInfo(){
		return adminHostInfo.findAll();
	}

}
