package com.system.college_erp_system.repo.party;

import com.system.college_erp_system.model.party.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Long> {
}
