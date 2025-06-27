package com.system.college_erp_system.repo.functional;

import com.system.college_erp_system.model.functional.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAttendanceRepo extends JpaRepository<StudentAttendance,Long> {
}
