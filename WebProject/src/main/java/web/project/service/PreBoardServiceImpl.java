package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.project.domain.PreBoard;
import web.project.persistence.PreBoardRepository;

@Service
public class PreBoardServiceImpl implements PreBoardService {
	
	@Autowired
	private PreBoardRepository preboardRepo;
	
	//글저장
	@Override
	public PreBoard saveBoard(PreBoard board) {
		return preboardRepo.save(board);
	}
	//글 목록보기
	@Override
	public Page<PreBoard> getBoardList(int pNum) {
		Pageable page = PageRequest.of(pNum-1, 5);
		return preboardRepo.findByOrderByBoardNumDesc(page);
	}
	
	//상세보기
	@Override
	public PreBoard viewPost(Long boardNum) {
		preboardRepo.updateReadcount(boardNum);
		return preboardRepo.findByBoardNum(boardNum);
	}
}
