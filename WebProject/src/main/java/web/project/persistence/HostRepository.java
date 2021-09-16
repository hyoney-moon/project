package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Host;

public interface HostRepository extends JpaRepository<Host, String> {

}
