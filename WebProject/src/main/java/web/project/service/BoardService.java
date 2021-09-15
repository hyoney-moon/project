package web.project.service;


import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import web.project.domain.Board;

@Configuration
public interface BoardService {

	Page<Board> getBoardList(int pNum);

	Board getBoard(Long boardNum);
	

}
