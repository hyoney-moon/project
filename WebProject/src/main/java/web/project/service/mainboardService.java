package web.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import web.project.domain.Board;

public interface mainboardService {
	public List<Board> getBoardList();
	//public List<BoardDto> getBoardList(Integer num);
}
