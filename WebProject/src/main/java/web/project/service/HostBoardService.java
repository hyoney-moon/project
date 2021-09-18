package web.project.service;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import web.project.domain.Board;

@Configuration
public interface HostBoardService {


	Board getBoard(Long boardNum);


	Board saveBoard(Board board);

	Board viewPost(Long boardNum);

	Page<Board> getHostBoardList(int pNum, String hostId);

}
