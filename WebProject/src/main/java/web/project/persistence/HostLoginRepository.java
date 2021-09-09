package web.project.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Host;

public interface HostLoginRepository extends JpaRepository<Host, Long> {

	Optional<Host> findByHostid(String hostid);




}
