package web.project.service;

import java.util.List;

import web.project.domain.Board;

public interface AdminPermitBoardService {

	List<Board> permitBoardList();
	
	// 게시글 승인
	void permitBoard(List<Long> boardNum);
	
	// 승인 전 게시글 삭제
	void deletePermitBoard(List<Long> boardNum);
}
