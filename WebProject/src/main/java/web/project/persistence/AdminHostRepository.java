package web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.Host;

public interface AdminHostRepository extends JpaRepository<Host, Long> {

	//가입날짜
	@Query(value="select count(*) from host where join_date < '2021-02-01'", nativeQuery=true)
	long countBeforeJan();
	@Query(value="select count(*) from host where join_date < '2021-03-01'", nativeQuery=true)
	long countBeforeFeb();
	@Query(value="select count(*) from host where join_date < '2021-04-01'", nativeQuery=true)
	long countBeforeMar();
	@Query(value="select count(*) from host where join_date < '2021-05-01'", nativeQuery=true)
	long countBeforeApr();
	@Query(value="select count(*) from host where join_date < '2021-06-01'", nativeQuery=true)
	long countBeforeMay();
	@Query(value="select count(*) from host where join_date < '2021-07-01'", nativeQuery=true)
	long countBeforeJun();
	@Query(value="select count(*) from host where join_date < '2021-08-01'", nativeQuery=true)
	long countBeforeJul();
	@Query(value="select count(*) from host where join_date < '2021-09-01'", nativeQuery=true)
	long countBeforeAug();
	@Query(value="select count(*) from host where join_date < '2021-10-01'", nativeQuery=true)
	long countBeforeSep();
	
//	//호스트 연령별
//	@Query(value="select count(*) from host where age between 10 and 19", nativeQuery = true)
//	long countAge10();
//	@Query(value="select count(*) from host where age between 20 and 29", nativeQuery = true)
//	long countAge20();
//	@Query(value="select count(*) from host where age between 30 and 39", nativeQuery = true)
//	long countAge30();
//	@Query(value="select count(*) from host where age between 40 and 49", nativeQuery = true)
//	long countAge40();
//	@Query(value="select count(*) from host where age between 50 and 59", nativeQuery = true)
//	long countAge50();
	

}
