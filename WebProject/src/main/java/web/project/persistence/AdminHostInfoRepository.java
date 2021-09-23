package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Host;

public interface AdminHostInfoRepository extends JpaRepository<Host, Long> {
	
	

}
