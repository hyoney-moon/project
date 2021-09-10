package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.PreBoard;

public interface AdminPreBoardRepository extends JpaRepository<PreBoard, Long> {

}
