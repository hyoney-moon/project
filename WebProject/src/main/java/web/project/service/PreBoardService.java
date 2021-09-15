package web.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import web.project.domain.PreBoard;

public interface PreBoardService {
	
	PreBoard saveBoard(PreBoard board);

	Page<PreBoard> getBoardList(int pNum);

	PreBoard viewPost(Long boardNum);


}
