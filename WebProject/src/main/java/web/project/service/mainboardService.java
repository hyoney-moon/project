package web.project.service;

import java.util.List;

import org.springframework.data.domain.Page;

import web.project.domain.BoardDto;

public interface mainboardService {
	public List<BoardDto> getBoardList();
	//public List<BoardDto> getBoardList(Integer num);
}
