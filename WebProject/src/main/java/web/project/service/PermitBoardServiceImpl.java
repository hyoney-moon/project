package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.persistence.PermitBoardRepository;

@Service
public class PermitBoardServiceImpl implements PermitBoardService {
	@Autowired
	private PermitBoardRepository permitBoard;

	@Override
	public List<Board> permitBoardList() {
		return permitBoard.permitBoardList();
	}

	@Override
	public void permitBoard(List<Long> boardNum) {
		
		for(int i=0; i < boardNum.size(); i++) {
			permitBoard.permitBoard(boardNum.get(i));	
		}
	}

	@Override
	public void deletePermitBoard(List<Long> boardNum) {
		
		for(int i=0; i < boardNum.size(); i++) {
			permitBoard.deletePermitBoard(boardNum.get(i));
		}
		
	}

}
