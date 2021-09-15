package web.project.service;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import web.project.domain.Member;
import web.project.persistence.MemberRepository;

/**
 * 회원 관련 작업을 처리해 주는 메소드의 원형을 소유한 클래스
 * id 중복 검사를 위한 메소드 선언
 */

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepo;

	@Override
	public Member joinMember(Member member) {
		return memberRepo.save(member);
	}
	
	@Override
	public Optional<Member> findMember(String id) {
		Optional<Member> member = memberRepo.findById(id);
		return member;
	}

	@Override
	public Member loginMember(Member member) {
		Optional<Member> findMember = memberRepo.findById(member.getCustId());
		if (findMember.isPresent())
			return findMember.get();
		else
			return null;
	}
	
	
//	@Override
//	public String idcheck(String custId) {
//		return memberRepo.idcheck(custId);
//	}
//	
	/*
	@Override
	public void register(MultipartHttpServletRequest request) {
		// 파라미터 읽어오기
		String custId = request.getParameter("custId");
		String password = request.getParameter("password");
		String nickame = request.getParameter("nickName");
		// 파일은 getFile 로 읽고 MultipartFile 로 저장한다
		MultipartFile profile = request.getFile("profile");
		
		// 파일 업로드 처리
		// 업로드 할 디렉토리를 문자열로 생성
		String uploadPath = request.getRealPath("/profile");
		
		// 파일 이름 생성 - 중복을 피하기 위해 UUID 와 원본 파일을 합해서 생성
		UUID uuid = UUID.randomUUID();
		String filename = profile.getOriginalFilename();
		String filepath = uploadPath + "/" + uuid + "_" + filename;
		
		// 파일 업로드와 DB 작업
		Member member = new Member();
		File file = new File(filepath);
		try {
			member.setCustId(custId);
			// 
			member.setPassword(password);
			member.setNickName(nickName);
			member.setProfile(uuid + "_" + filename);
			// 파일 업로드
			profile.transferTo(file);
			// DB 메소드 호출
			memberRepo.register(member);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	
	/*
	 * public String registerMember(@RequestBody Member joinMember) {
	 * 
	 * String cust_id = joinMember.getCustId(); String password =
	 * joinMember.getPassword(); String custId = joinMember.getId(); // 파일은
	 * getFile 로 읽고 MultipartFile 로 저장한다 String profile = joinMember.getProfile();
	 * 
	 * }
	 */
//	
//	
//	@Override
//	public Member login(HttpServletRequest request) {
//		// 파라미터 읽기
//		String custId = request.getParameter("custId");
//		String password = request.getParameter("password");
//		
//		// id 에 해당하는 데이터 불러오기
//		// null 이 리턴되는 경우 없는 id 이다
//		Member member = memberRepo.login(custId);
//		if(member != null) {
//			// 패스워드 확인
//			if(BCrypt.checkpw(password, member.getPassword())) {
//				// 패스워드는 삭제
//				member.setPassword(null);
//			}else {
//				// 패스워드가 틀렸으므로 null 로 변경
//				member = null;
//			}
//		}
//		return member;
//	}
	

}
