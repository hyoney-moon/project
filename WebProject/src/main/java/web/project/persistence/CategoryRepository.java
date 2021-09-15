package web.project.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Category;


public interface CategoryRepository  extends JpaRepository<Category, Long>{
	
	public List<Category> findAll();

}
