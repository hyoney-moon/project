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
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public Page<Board> getBoardList(int pNum){
		Pageable page = PageRequest.of(pNum-1, 5);
		return boardRepo.findByOrderByNumDesc(page);
	}
	@Override
	public void saveBoard(Board board) {
		boardRepo.save(board);
	}
	
	@Override
	public Board getBoard(Long num) {
		boardRepo.updateCnt(num);
		return boardRepo.getById(num);
	}
	@Override
	public Board onlyBoard(Long num) {
		return boardRepo.getById(num);
	}
	@Override
	public void deleteBoard(Long num) {
		boardRepo.deleteById(num);
	}
	@Override
	public Page<Board> getBoardList(int pNum, int searchn, String search) {
		Pageable page = PageRequest.of(pNum-1, 5);
		Page<Board> list = null;
		if(searchn == 0) {
			list = boardRepo.findByTitleContainingIgnoreCase(search, page);
		}else if(searchn == 1) {
			list = boardRepo.findByContentContainingIgnoreCase(search, page);
		}else if (searchn == 2) {
			list =  boardRepo.findByWriterContainingIgnoreCase(search, page);
		}
		return list;
	}
}
