package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.persistence.AdminPermitBoardRepository;

@Service
public class AdminPermitBoardServiceImpl implements AdminPermitBoardService {
	@Autowired
	private AdminPermitBoardRepository adminPermitBoardRepository;

	@Override
	public List<Board> permitBoardList() {
		return adminPermitBoardRepository.permitBoardList();
	}

	@Override
	public void permitBoard(List<Long> boardNum) {
		
		for(int i=0; i < boardNum.size(); i++) {
			adminPermitBoardRepository.permitBoard(boardNum.get(i));	
		}
	}

	@Override
	public void rejectPermitBoard(List<Long> boardNum) {
		
		for(int i=0; i < boardNum.size(); i++) {
			adminPermitBoardRepository.rejectPermitBoard(boardNum.get(i));
		}
		
	}

}
