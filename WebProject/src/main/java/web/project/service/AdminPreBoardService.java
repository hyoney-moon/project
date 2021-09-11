package web.project.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import web.project.domain.PreBoard;

@Configuration
public interface AdminPreBoardService {

	// 게시글 목록 조회
	List<PreBoard> PreBoardList();
	
	// 게시글 여러개 삭제
	void deletePreBoard(List<Long> boardNum);
}
