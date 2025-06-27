package com.system.college_erp_system.repo.party;

import com.system.college_erp_system.model.party.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Long> {

}
