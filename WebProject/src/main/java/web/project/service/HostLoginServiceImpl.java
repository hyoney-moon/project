package web.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Customer;
import web.project.domain.Host;
import web.project.persistence.HostLoginRepository;


@Service
public class HostLoginServiceImpl implements HostLoginService {
	
	@Autowired
	private HostLoginRepository hostLoginRepo;
	
	@Override
	public Host getHost(Host host) {
		Optional<Host> findHost = hostLoginRepo.findByHostId(host.getHostId());
		if(findHost.isPresent())
			return findHost.get();
		else
			return null;
	}
	
	@Override
	public Host joinHost(Host host) {
		return hostLoginRepo.save(host);
	}
	
	@Override
	public void hostDelete(Host host) {
		hostLoginRepo.delete(host);
	}
	
	@Override
	public Optional<Host> findHostId(String hostId) {
		Optional<Host> host = hostLoginRepo.findByHostId(hostId);
		return host;
	}


}
