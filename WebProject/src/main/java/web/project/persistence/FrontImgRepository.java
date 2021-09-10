package web.project.persistence;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.FrontImg;

public interface FrontImgRepository extends JpaRepository<FrontImg, Long> {
	
	
}
