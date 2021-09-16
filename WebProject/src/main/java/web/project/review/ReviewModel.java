package web.project.review;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository("dataSource")
public class ReviewModel extends DriverManagerDataSource {
	public ReviewModel() {
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		setUsername("c##javashin");
		setPassword("javashin");
	}
}