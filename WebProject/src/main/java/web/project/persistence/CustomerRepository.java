package web.project.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.project.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

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
	
}
