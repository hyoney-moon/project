package web.project.service;

import org.springframework.data.domain.Page;

import web.project.domain.Board;

public interface BoardService {

	void saveBoard(Board board);
	Page<Board> getBoardList(int pNum);
	Board getBoard(Long num);
	Board onlyBoard(Long num);
	void deleteBoard(Long num);
	Page<Board> getBoardList(int pNum, int searchn, String search);
	
}
