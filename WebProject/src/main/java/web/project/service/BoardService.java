package web.project.service;


import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import web.project.domain.Board;

@Configuration
public interface BoardService {

	Board getBoardNum(Long boardNum);
//	Board getcustId(String custId);
	
	Page<Board> getBoardList(int pNum);

	Board getBoard(Long boardNum);
	

	Page<Board> searchBoardList(int pNum, int search_option, String search);

	Board saveBoard(Board board);

	Board viewPost(Long boardNum);
}
