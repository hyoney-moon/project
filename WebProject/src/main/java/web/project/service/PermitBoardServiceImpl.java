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

}
