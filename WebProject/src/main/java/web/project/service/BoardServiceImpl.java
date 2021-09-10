package web.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.persistence.BoardRepositoryRepository;
//
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepositoryRepository boardRepo;
	
	// 게시글 목록
	@Override
	public Page<Board> getBoardList(int pNum) {
		Pageable page = PageRequest.of(pNum-1, 5);
		return boardRepo.findByOrderByBoardNumDesc(page);
	}

	// 게시글 조회
	@Override
	public Board getBoard(Long boardNum) {
		return boardRepo.getById(boardNum);
	}

	@Override
	public void insertAllBoard(List<Board> board) {
		boardRepo.saveAll(board);
	}
}
