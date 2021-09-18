package web.project.service;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import web.project.domain.Board;

@Configuration
public interface CustBoardService {

	Page<Board> getCustBoardList(int pNum);

	Board getBoard(Long boardNum);

	Page<Board> searchBoardList(int pNum, int search_option, String search);

	Board viewPost(Long boardNum);


}
