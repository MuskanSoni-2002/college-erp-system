package com.system.college_erp_system.service.party.role;

import com.system.college_erp_system.model.party.role.PartyRole;
import com.system.college_erp_system.repo.party.role.PartyRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyRoleService {

    @Autowired
    private PartyRoleRepo partyRoleRepo;
    public PartyRole createPartyRole(PartyRole prl) {
        return partyRoleRepo.save(prl);
    }
}
