package web.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepo;
	
	// 게시글 조회
	@Override
	public Board getBoard(Long boardNum) {
		return boardRepo.getById(boardNum);
	}
}
