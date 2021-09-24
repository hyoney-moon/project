package web.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.domain.Admin;
import web.project.persistence.AdminLoginRepository;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminLoginRepository adminLoginRepository;
	
	@Override
	public Admin getAdmin(Admin admin) {
		Optional<Admin> findAdmin = adminLoginRepository.findByAdminId(admin.getAdminId());
		if(findAdmin.isPresent()) {
			System.out.print("성공");
			return findAdmin.get();	
		}
		else {
			return null;
		}
	}

	@Override
	public Optional<Admin> findAdmin(String adminId) {
		Optional<Admin> admin =  adminLoginRepository.findByAdminId(adminId);
		return admin;
	}
}
