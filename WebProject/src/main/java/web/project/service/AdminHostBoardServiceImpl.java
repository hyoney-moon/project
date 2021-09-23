package web.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.persistence.AdminHostBoardRepository;
import web.project.persistence.AdminHostRepository;

@Service
public class AdminHostBoardServiceImpl implements AdminHostBoardService {

	@Autowired
	AdminHostBoardRepository adHostBoardRepo;
	
	//게시글 수 월별로
	@Override
	public List<Long> getBoardCount(){
		long boardCountJan = adHostBoardRepo.boardCountJan();
		long boardCountFeb = adHostBoardRepo.boardCountFeb();
		long boardCountMar = adHostBoardRepo.boardCountMar();
		long boardCountApr = adHostBoardRepo.boardCountApr();
		long boardCountMay = adHostBoardRepo.boardCountMay();
		long boardCountJun = adHostBoardRepo.boardCountJun();
		long boardCountJul = adHostBoardRepo.boardCountJul();
		long boardCountAug = adHostBoardRepo.boardCountAug();
		long boardCountSep = adHostBoardRepo.boardCountSep();
		long boardCountOct = adHostBoardRepo.boardCountOct();
		long boardCountDec = adHostBoardRepo.boardCountDec();
		long boardCountNov = adHostBoardRepo.boardCountNov();
		
		
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
		boardCountList.add(boardCountOct);
		boardCountList.add(boardCountDec);
		boardCountList.add(boardCountNov);
		
		return boardCountList;

	}
	
	
}
