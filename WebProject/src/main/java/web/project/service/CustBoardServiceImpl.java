package web.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.persistence.CustBoardRepository;
import web.project.persistence.HostBoardRepository;
//
@Service
public class CustBoardServiceImpl implements CustBoardService {

	@Autowired
	CustBoardRepository boardRepo;
	
	// 게시글 목록
	@Override
	public Page<Board> getCustBoardList(int pNum) {
		Pageable page = PageRequest.of(pNum-1, 5);
		return boardRepo.findByOrderByBoardNumDesc(page);
	}
	
	//저장된 게시글 상세보기
	@Override
	public Board viewPost(Long boardNum) {
		boardRepo.updateReadcount(boardNum);
		return boardRepo.findByBoardNum(boardNum);
	}

	//게시글 조회
	@Override
	public Board getBoard(Long boardNum) {
		return boardRepo.getById(boardNum);
	}
	
			
	//검색하기
	@Override
	public Page<Board> searchBoardList(int pNum, int search_option, String search) {
		Pageable page = PageRequest.of(pNum-1, 5);
		Page<Board> list = null;
		if(search_option == 1) {
			list = boardRepo.findBySpaceNameContainingIgnoreCase(search, page);
		} else if(search_option == 2) {
			list = boardRepo.findByCategoryContainingIgnoreCase(search, page);
		} else if(search_option == 3) {
			list = boardRepo.findByAddressContainingIgnoreCase(search, page);
		} else {
			list = boardRepo.findBySpaceNameOrCategoryOrAddressContainingIgnoreCase(search, search, search, page);
		}
		return list;
	}
	
}
