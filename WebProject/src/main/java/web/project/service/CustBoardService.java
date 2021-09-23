package web.project.service;


import java.util.List;

import org.springframework.data.domain.Page;

import web.project.domain.Board;

public interface CustBoardService {

	Page<Board> getCustBoardList(int pNum);

	Board getBoard(Long boardNum);

//	Page<Board> searchBoardList(int pNum, int search_option, String search);

	Board viewPost(Long boardNum);

	List<Board> searchBoardList(int search_option, String search);



}
