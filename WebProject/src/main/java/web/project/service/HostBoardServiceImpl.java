package web.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.persistence.HostBoardRepository;
//
@Service
public class HostBoardServiceImpl implements HostBoardService {

	@Autowired
	HostBoardRepository boardRepo;
	
	//글저장
	@Override
	public Board saveBoard(Board board) {
		return boardRepo.save(board);
	}
	
	// 게시글 목록
	@Override
	public Page<Board> getHostBoardList(int pNum, String hostId) {
		Pageable page = PageRequest.of(pNum-1, 5);
		return boardRepo.findByHostIdOrderByBoardNumDesc(hostId, page);
	}
	
	//호스트 아이디로 저장된 게시글 상세보기
	@Override
	public Board viewPost(Long boardNum) {
		boardRepo.updateReadcount(boardNum);
		return boardRepo.findByBoardNum(boardNum);
	}

	//게시글 조회
	@Override
	public Board getBoard(Long boardNum) {
		return boardRepo.getById(boardNum);
	}
	
}
