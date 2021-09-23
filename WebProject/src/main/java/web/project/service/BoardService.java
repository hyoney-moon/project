package web.project.service;


import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import web.project.domain.Board;

public interface BoardService {

	Page<Board> getCustBoardList(int pNum);

	List<Board> searchBoardList(int search_option, String search);
	
	Board getBoard(Long boardNum);
	
	Board saveBoard(Board board);

	Board viewPost(Long boardNum);

	Page<Board> getHostBoardList(int pNum, String hostId);

}
