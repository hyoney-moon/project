package web.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Host;
import web.project.persistence.HostRepository;

@Service
public abstract class HostServiceImpl implements HostService {

	@Autowired
	HostRepository hostRepo;

	public Host saveMember(Host host) {
		return hostRepo.save(host);
	}

	@Override
	public Host getMember(Host host) {
		Optional<Host> findHost = hostRepo.findById(host.getId());
		if (findHost.isPresent())
			return findHost.get();
		else
			return null;
	}


	@Override
	public Optional<Host> findHost(String id) {
		Optional<Host> member = hostRepo.findById(id);
		return member;
	}
	@Override
	public void delete(Host host) {
		hostRepo.delete(host);
	}

}
