package com.pk.springboard.service;

import java.io.File;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pk.springboard.dao.UserDao;
import com.pk.springboard.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public String idcheck(String email) {
		return userDao.idcheck(email);
	}

	@Override
	public void register(MultipartHttpServletRequest request) {
		//파라미터를 읽어오기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");
		//파일은 getFile로 읽고 MultipartFile로 저장
		MultipartFile image = request.getFile("image");
		
		//파일 업로드 처리
		//업로드할 디렉토리를 문자열로 생성
		String uploadPath =
				request.getRealPath("/userimage");
		//파일 이름 만들기 - 중복을 시키지 않기 위해서 UUID와 원본 파일을
		//합쳐서 생성
		UUID uuid = UUID.randomUUID();
		String filename = image.getOriginalFilename();
		String filepath = uploadPath + "/" + uuid + "_" + filename;
		
		//파일업로드와 데이터베이스 작업
		User user = new User();
		File file = new File(filepath);
		try {
			user.setEmail(email);
			//비밀번호는 암호화
			user.setPw(BCrypt.hashpw(pw,BCrypt.gensalt()));
			user.setNickname(nickname);
			user.setImage(uuid + "_" + filename);
			//파일 업로드
			image.transferTo(file);
			//데이터베이스 메소드 호출
			userDao.register(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}











