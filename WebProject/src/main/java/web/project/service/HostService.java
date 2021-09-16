package web.project.service;

import java.util.Optional;

import web.project.domain.Host;

public interface HostService {
	Host saveMember(Host host);

	Host getMember(Host host);
	
	Optional<Host> findHost(String id);
	
	void delete(Host host);

	Host getHost(Host host);

	Host saveHost(Host host);

}
