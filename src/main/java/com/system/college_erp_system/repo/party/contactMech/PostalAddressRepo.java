package com.system.college_erp_system.repo.party.contactMech;

import com.system.college_erp_system.model.party.contactMech.PostalAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostalAddressRepo extends JpaRepository<PostalAddress,Long> {
}
