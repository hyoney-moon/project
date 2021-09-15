package web.project.persistence;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	
	// 아이디 중복 체크를 위한 네이티브 쿼리
	@Query(value = "select cust_id from member where cust_id = :cust_id", nativeQuery=true)
	String idcheck(String cust_id);


	// 회원가입 처리를 위한 네이티브 쿼리
	/*
	@query(value = "insert into member(custId,")
	
	// 로그인 처리를 위한 네티이브 쿼리
	<select id="login" resultType="Member" parameterType="Member">
	select custId, nickName, profile, password
	from member
	where cust_id=#{cust_id}
	</select>
	*/
	
	// 삭제된 MemberDao
	/*
	public String idcheck(String cust_id) {
		// 파라미터 존재 여부를 확인
		return sqlSession.selectOne("member.idcheck", cust_id);
	}
	
	// 회원가입을 처리할 메소드
	public void register(Member member){
		sqlSession.insert("member.register", member);
	}
	
	// 로그인 처리를 위한 메소드
	public Member login(String cust_id){
		return sqlSession.selectOne("member.login", cust_id);
	}
	*/
}