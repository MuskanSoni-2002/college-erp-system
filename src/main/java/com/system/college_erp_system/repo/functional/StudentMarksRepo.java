package com.system.college_erp_system.repo.functional;

import com.system.college_erp_system.model.functional.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentMarksRepo extends JpaRepository<StudentMarks,Long> {
}
