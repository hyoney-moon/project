package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import web.project.domain.PreBoard;

public interface AdminPreBoardRepository extends JpaRepository<PreBoard, Long> {

	@Transactional
	void deleteAllByboardNumIn(List<Long> boardNum);
}
