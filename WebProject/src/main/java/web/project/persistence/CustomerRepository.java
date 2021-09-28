package web.project.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	
	// 회원 가입 날짜 통계
	@Query(value="select count(*) from customer where join_date < '2021-02-01'", nativeQuery=true)
	long countBeforeJan();
	@Query(value="select count(*) from customer where join_date < '2021-03-01'", nativeQuery=true)
	long countBeforeFeb();
	@Query(value="select count(*) from customer where join_date < '2021-04-01'", nativeQuery=true)
	long countBeforeMar();
	@Query(value="select count(*) from customer where join_date < '2021-05-01'", nativeQuery=true)
	long countBeforeApr();
	@Query(value="select count(*) from customer where join_date < '2021-06-01'", nativeQuery=true)
	long countBeforeMay();
	@Query(value="select count(*) from customer where join_date < '2021-07-01'", nativeQuery=true)
	long countBeforeJun();
	@Query(value="select count(*) from customer where join_date < '2021-08-01'", nativeQuery=true)
	long countBeforeJul();
	@Query(value="select count(*) from customer where join_date < '2021-09-01'", nativeQuery=true)
	long countBeforeAug();
	@Query(value="select count(*) from customer where join_date < '2021-10-01'", nativeQuery=true)
	long countBeforeSep();
	
	// 연령 분포
	@Query(value="select count(*) from customer where age between 10 and 19", nativeQuery=true)
	long countAge10();
	@Query(value="select count(*) from customer where age between 20 and 29", nativeQuery=true)
	long countAge20();
	@Query(value="select count(*) from customer where age between 30 and 39", nativeQuery=true)
	long countAge30();
	@Query(value="select count(*) from customer where age between 40 and 49", nativeQuery=true)
	long countAge40();
	@Query(value="select count(*) from customer where age between 50 and 59", nativeQuery=true)
	long countAge50();
	
	// 성비 비율
	@Query(value="select count(*) from customer where gender = 'm'", nativeQuery=true)
	long countGenderM();
	@Query(value="select count(*) from customer where gender = 'w'", nativeQuery=true)
	long countGenderW();
	
	// 아이디 중복 체크를 위한 네이티브 쿼리(미완성)
		@Query(value = "select custId from customer where custId = ?", nativeQuery=true)
		String idcheck(String custId);
		
		Customer findByCustId(String custId);
	
}
