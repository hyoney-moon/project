package web.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import web.project.domain.Board;

public interface BoardService {
	
	Board saveBoard(Board board);

	Page<Board> getBoardList(int pNum);


}
