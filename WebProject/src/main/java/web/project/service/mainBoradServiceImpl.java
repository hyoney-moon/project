package web.project.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.persistence.mainBoardRepository;

@Service
public class mainBoradServiceImpl implements mainboardService {
	
	@Autowired
	mainBoardRepository repository;

	
	
	//랜덤으로 7개의 값을 가져오기 기능 
	
	  public List<Board> getBoardList(){ 
		  
		  List<Board> dto = repository.findAll();
	  
	  return dto;
	  
	  }
	 
	/*
	 * @Override public List<BoardDto> getBoardList(Integer num){
	 * 
	 * }
	 */
	
}
