package com.system.college_erp_system.repo.party;

import com.system.college_erp_system.model.party.PartyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRelationshipRepo extends JpaRepository<PartyRelationship,Long> {
}
