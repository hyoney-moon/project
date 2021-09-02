package web.project.service;


import org.springframework.context.annotation.Configuration;

import web.project.domain.Board;

@Configuration
public interface BoardService {

	Board getBoard(Long boardNum);

}
