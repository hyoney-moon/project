package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Img;

public interface ImgRepository extends JpaRepository<Img, Long> {

}
