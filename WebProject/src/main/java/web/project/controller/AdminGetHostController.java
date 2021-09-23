package web.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import web.project.domain.Host;
import web.project.service.AdminGetHostService;
import web.project.service.AdminHostBoardService;
import web.project.service.AdminHostInfoService;
import web.project.service.AdminHostService;

@Controller
@RequestMapping("/admin")
public class AdminGetHostController {
	
	@Autowired
	private AdminGetHostService adminGetHostService;
	@Autowired
	private AdminHostInfoService adminHostInfoService;
	@Autowired
	private AdminHostService hostService;
	@Autowired
	private AdminHostBoardService boardService;
	
	@RequestMapping("/adminmain")
	public String adminMain() {
		return "admin_main/adminmain";
	}
	
	//Host 리스트 Gson으로 받아오기
	@GetMapping("/hostList")
	@ResponseBody
	public String hostList() {
		List<Host> result = adminGetHostService.hostInfo();
		Gson json = new Gson();
		return json.toJson(result);
	}
	@GetMapping("/getHostList")
	public String getHostList() {
		return "admin_board/hostInfo";
	}
	
	//엑셀 다운
	@RequestMapping("/excelDown")
	public void excelDown(HttpServletResponse response) throws Exception {
		List<Host> result = adminGetHostService.hostInfo();
		
		// 워크북 생성
	    Workbook wb = new HSSFWorkbook();
	    Sheet sheet = wb.createSheet("일반고객명단");
	    Row row = null;
	    Cell cell = null;
	    int rowNo = 0;
	    
	    // 테이블 헤더용 스타일
	    CellStyle headStyle = wb.createCellStyle();
	    // 가는 경계선을 가집니다.
	    headStyle.setBorderTop(BorderStyle.THIN);
	    headStyle.setBorderBottom(BorderStyle.THIN);
	    headStyle.setBorderLeft(BorderStyle.THIN);
	    headStyle.setBorderRight(BorderStyle.THIN);

	    // 데이터용 경계 스타일 테두리만 지정
	    CellStyle bodyStyle = wb.createCellStyle();
	    bodyStyle.setBorderTop(BorderStyle.THIN);
	    bodyStyle.setBorderBottom(BorderStyle.THIN);
	    bodyStyle.setBorderLeft(BorderStyle.THIN);
	    bodyStyle.setBorderRight(BorderStyle.THIN);

	    // 헤더 생성
	    row = sheet.createRow(rowNo++);
	    cell = row.createCell(0);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("아이디");
	    
	    cell = row.createCell(1);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("닉네임");
	    
	    cell = row.createCell(2);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("성별");
	    
	    cell = row.createCell(3);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("나이");
	    
	    cell = row.createCell(4);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("지역");

	    // 데이터 부분 생성
	    for(Host customer : result) {
	        row = sheet.createRow(rowNo++);
	        cell = row.createCell(0);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(customer.getHostId());

	        cell = row.createCell(1);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(customer.getNickName());

	        cell = row.createCell(2);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(customer.getGender());
	        
	    }
	        // 컨텐츠 타입과 파일명 지정
	        response.setContentType("ms-vnd/excel");
	        response.setHeader("Content-Disposition", "attachment;filename=hostDB.xls");

	        // 엑셀 출력
	        wb.write(response.getOutputStream());
	        wb.close();

		}
	
	@GetMapping("/getHostInfo")
	public String getCustomerInfo(Model m) {
		// 일반회원 통계 조회
		List<Long> hostNumList = hostService.getHostCount();
		m.addAttribute("hostNumList",hostNumList);
		
		// 게시글 수 통계 조회
		List<Long> boardCountList = boardService.getBoardCount();
		m.addAttribute("boardCountList", boardCountList);
		
		// 총 거래액 통계 조회(컬럼 추가 후 작성)
		
		// 연령 분포 통계
//		List<Long> hostAgeList = hostService.getHostAge();
//		m.addAttribute("hostAgeList", hostAgeList);
		
		// 성비
//		List<Long> genderList = hostService.getCustGender();
//		m.addAttribute("genderList",genderList);
		
		return "admin_board/hostInfo";
	}

}
