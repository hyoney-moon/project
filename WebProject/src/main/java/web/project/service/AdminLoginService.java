package web.project.service;

import java.util.Optional;

import web.project.domain.Admin;

public interface AdminLoginService {

	// 관리자 로그인
	Admin getAdmin(Admin admin);
	Optional<Admin> findAdmin(String adminId);
}
