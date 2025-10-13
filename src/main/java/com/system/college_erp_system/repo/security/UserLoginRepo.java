package com.system.college_erp_system.repo.security;

import com.system.college_erp_system.model.security.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin,String> {
}
