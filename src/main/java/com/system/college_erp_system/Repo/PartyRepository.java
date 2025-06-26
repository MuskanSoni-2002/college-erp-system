package com.system.college_erp_system.Repo;

import com.system.college_erp_system.model.party.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party,Long> {

}
