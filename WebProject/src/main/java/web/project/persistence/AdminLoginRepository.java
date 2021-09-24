package web.project.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.domain.Admin;

public interface AdminLoginRepository extends JpaRepository<Admin, String> {
	
	Optional<Admin> findByAdminId(String adminId);
}
