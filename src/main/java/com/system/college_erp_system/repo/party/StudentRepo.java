package com.system.college_erp_system.repo.party;

import com.system.college_erp_system.model.party.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}
