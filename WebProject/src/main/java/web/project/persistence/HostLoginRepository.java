package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Host;

public interface HostLoginRepository extends JpaRepository<Host, String> {

}
