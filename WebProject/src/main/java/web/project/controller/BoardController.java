package web.project.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import web.project.domain.Board;
import web.project.domain.FrontImg;
import web.project.domain.Host;
import web.project.domain.Img;
import web.project.service.BoardService;
import web.project.service.FrontImgService;
import web.project.service.ImgService;

@SessionAttributes("host")
@Controller
public class BoardController implements ApplicationContextAware {
	
	private WebApplicationContext context = null;
	
	@ModelAttribute("host")
	public Host getHost() {
		return new Host();
	}
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private FrontImgService frontImgService;
	@Autowired
	private ImgService imgService;
	
	@PostMapping("/boardList")
	public String insertBoard(Board board, @ModelAttribute("host")Host host,List<MultipartFile> frontImg, List<MultipartFile> img) {
		board.setHostid(host.getHostid());
		Board b =  boardService.saveBoard(board);
		System.out.println(b.getBoardNum());
		
		//프론트 이미지 업로드
		for (MultipartFile file : frontImg) {
		String path = getFrontPath(file);
		FrontImg fi = new FrontImg();
		fi.setBoardNum(b.getBoardNum());
		fi.setFilename(path);
		fi.setFilePath(path);
		fi.setOrigFilename(file.getOriginalFilename());
		
		//save
		frontImgService.saveFrontImg(fi);
		}
		
		//이미지 업로드
		for (MultipartFile file : img) {
		String path = getImgPath(file);
		Img im = new Img();
		im.setBoardNum(b.getBoardNum());
		im.setFilename(path);
		im.setFilePath(path);
		im.setOrigFilename(file.getOriginalFilename());
				
		//save
		imgService.saveImg(im);
		}
		return "redirect:/";
	}
	
	//(이미지)실제 업로드할 경로 만드는 부분
	private String getImgPath(MultipartFile img) {
		
		String oriName = img.getOriginalFilename(); //저장 된 파일의 원본 이름
		int index = oriName.lastIndexOf(".");
		String ext = oriName.substring(index+1); //파일 이름 겹치지 않게 지정
		Random r = new Random();
		String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;
	
		String path = context.getServletContext().getRealPath("WEB-INF/img/Img/"+fileName); 
    
		try {
			img.transferTo(new File(path));
		}catch(IllegalStateException | IOException e){
			e.printStackTrace();
		}
		
		return "WEB-INF/img/frontImg/"+fileName;
	}
	
	//(프론트이미지)실제 업로드할 경로 만드는 부분
	private String getFrontPath(MultipartFile frontImg) {
		
			String oriName = frontImg.getOriginalFilename(); //저장 된 파일의 원본 이름
			int index = oriName.lastIndexOf(".");
			String ext = oriName.substring(index+1); //파일 이름 겹치지 않게 지정
			Random r = new Random();
			String fileName = System.currentTimeMillis() + "_" + r.nextInt(50) + "." + ext;
		
			String path = context.getServletContext().getRealPath("WEB-INF/img/frontImg/"+fileName); 
        
			try {
				frontImg.transferTo(new File(path));
			}catch(IllegalStateException | IOException e){
				e.printStackTrace();
			}
			
        return "WEB-INF/img/frontImg/"+fileName;
     }
	
	@Override
    public void setApplicationContext(ApplicationContext applicationContext)
          throws BeansException {
       this.context = (WebApplicationContext) applicationContext;
    }
	

}
