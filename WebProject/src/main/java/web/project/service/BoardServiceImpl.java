package web.project.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.project.domain.Board;
import web.project.persistence.BoardRepository;
//
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepo;
	
	// 게시글 목록
	@Override
	public Page<Board> getBoardList(int pNum) {
		Pageable page = PageRequest.of(pNum-1, 5);
		return boardRepo.findByOrderByBoardNumDesc(page);
	}

	// 게시글 조회
	@Override
	public Board getBoard(Long boardNum) {
		return boardRepo.getById(boardNum);
	}

	@Override
	public void insertAllBoard(List<Board> board) {
		boardRepo.saveAll(board);
	}

	// 게시글 수 통계 조회
	@Override
	public List<Long> getBoardCount() {
		long boardCountJan = boardRepo.boardCountJan();
		long boardCountFeb = boardRepo.boardCountFeb();
		long boardCountMar = boardRepo.boardCountMar();
		long boardCountApr = boardRepo.boardCountApr();
		long boardCountMay = boardRepo.boardCountMay();
		long boardCountJun = boardRepo.boardCountJun();
		long boardCountJul = boardRepo.boardCountJul();
		long boardCountAug = boardRepo.boardCountAug();
		long boardCountSep = boardRepo.boardCountSep();
		
		List<Long> boardCountList = new ArrayList<>();
		boardCountList.add(boardCountJan);
		boardCountList.add(boardCountFeb);
		boardCountList.add(boardCountMar);
		boardCountList.add(boardCountApr);
		boardCountList.add(boardCountMay);
		boardCountList.add(boardCountJun);
		boardCountList.add(boardCountJul);
		boardCountList.add(boardCountAug);
		boardCountList.add(boardCountSep);
		
		return boardCountList;
	}
	
	//상세보기
	@Override
	public Board viewPost(Long boardNum) {
		boardRepo.updateReadcount(boardNum);
		return boardRepo.findByBoardNum(boardNum);
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
	//글저장
	@Override
	public Board saveBoard(Board board) {
		return boardRepo.save(board);
	}
}
