package com.system.college_erp_system.repo.functional;

import com.system.college_erp_system.model.functional.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,String> {
}
