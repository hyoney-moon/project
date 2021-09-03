package web.project.service;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import web.project.domain.Board;

@Configuration
public interface BoardService {

	Page<Board> getBoardList(int pNum);

	Board getBoard(Long boardNum);

}
