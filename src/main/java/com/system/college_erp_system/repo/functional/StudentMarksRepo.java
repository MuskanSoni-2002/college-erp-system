package com.system.college_erp_system.repo.functional;

import com.system.college_erp_system.model.functional.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMarksRepo extends JpaRepository<StudentMarks,Long> {
}
