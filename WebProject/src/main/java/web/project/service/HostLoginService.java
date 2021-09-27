package web.project.service;

import java.util.Optional;

import web.project.domain.Customer;
import web.project.domain.Host;

public interface HostLoginService {
	//호스트 로그인
	Host getHost(Host host);
	
	//회원가입
	Host joinHost(Host host);
	
	//회원탈퇴
	void hostDelete(Host host);
	
	Optional<Host> findHostId(String HostId);


}
