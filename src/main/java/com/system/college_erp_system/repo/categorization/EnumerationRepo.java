package com.system.college_erp_system.repo.categorization;

import com.system.college_erp_system.model.categorization.Enumeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnumerationRepo extends JpaRepository<Enumeration,String> {

}
