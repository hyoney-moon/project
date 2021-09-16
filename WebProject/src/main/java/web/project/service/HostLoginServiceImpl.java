package web.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Host;
import web.project.persistence.HostLoginRepository;


@Service
public class HostLoginServiceImpl implements HostLoginService {
	
	@Autowired
	private HostLoginRepository hostLoginRepo;
	
	@Override
	public Host getHost(Host host) {
		Optional<Host> findHost = hostLoginRepo.findByHostid(host.getHostid());
		if(findHost.isPresent())
			return findHost.get();
		else
			return null;
	}

}
