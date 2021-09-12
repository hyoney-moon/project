package web.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	//글저장
	@Override
	public Board saveBoard(Board board) {
		return boardRepo.save(board);
	}
	//글 목록보기
	@Override
	public Page<Board> getBoardList(int pNum) {
		Pageable page = PageRequest.of(pNum-1, 5);
		return boardRepo.findByOrderByBoardNumDesc(page);
	}
}
