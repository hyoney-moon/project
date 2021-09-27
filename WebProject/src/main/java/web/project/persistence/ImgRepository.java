package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.FrontImg;
import web.project.domain.Img;

public interface ImgRepository extends JpaRepository<Img, Long> {

	List<Img> findByBoardNumOrderByImgNoDesc(Long boardNum);

}
