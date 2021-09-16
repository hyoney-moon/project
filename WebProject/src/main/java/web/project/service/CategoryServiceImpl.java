package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Category;
import web.project.persistence.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository cateRepo;
	
	@Override
	public List<Category> selectCate() {
		return cateRepo.findAll();
	}

}
