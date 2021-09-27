package web.project.service;


import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import web.project.domain.Board;


public interface BoardService {

	Board getBoardNum(Long boardNum);
//	Board getcustId(String custId);
	
	Page<Board> getBoardList(int pNum);


	List<Board> searchBoardList(int search_option, String search);
	
	Board getBoard(Long boardNum);
	
	void insertAllBoard(List<Board> board);

	// 게시글 수 조회 통계
	List<Long> getBoardCount();

	Page<Board> searchBoardList(int pNum, int search_option, String search);

	Board saveBoard(Board board);

	Board viewPost(Long boardNum);

	Page<Board> getHostBoardList(int pNum, String hostId);

	Page<Board> getCustBoardList(int pNum);

	void deleteById(Long boardNum);

}
