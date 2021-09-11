package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.PreBoard;
import web.project.persistence.AdminPreBoardRepository;

@Service
public class AdminPreBoardServiceImpl implements AdminPreBoardService {

	@Autowired
	private AdminPreBoardRepository adminPreBoardRepository;
	
	@Override
	public List<PreBoard> PreBoardList() {
		return adminPreBoardRepository.findAll();
	}

	@Override
	public void deletePreBoard(List<Long> boardNum) {
		adminPreBoardRepository.deleteAllByboardNumIn(boardNum);
	}

}
