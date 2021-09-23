package web.project.persistence;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import web.project.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	@Autowired
	
	// 아이디 중복 체크를 위한 네이티브 쿼리
	@Query(value = "select custId from member where custId = :custId", nativeQuery=true)
	String idcheck(String custId);

	// void registerCustomer(Customer customer);
	
	/*
	<select id="idcheck" resultType="java.lang.String" parameterType="java.lang.String">
	select cust_id
	from member
	where cust_id = #{cust_id};
	<select>
	*/
}