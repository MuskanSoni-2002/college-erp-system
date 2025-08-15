package com.system.college_erp_system.service.party;

import com.system.college_erp_system.model.party.Party;
import com.system.college_erp_system.repo.party.PartyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.system.college_erp_system.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyService {

    @Autowired
    private PartyRepo partyRepo;

    public Long createParty(Party party){
        Party p = partyRepo.save(party);
        return p.getPartyId();
    }

    public Party putParty(Long partyId,Party updatedParty){
        if (!partyRepo.existsById(partyId)) {
            throw new ResourceNotFoundException("Party not found with id: " + partyId);
        }
       return partyRepo.save(updatedParty);
    }

    public Party getParty(Long partyId){
        return partyRepo.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party not found with id: " + partyId));
    }

    public List<Party> getAllParties(){
        return partyRepo.findAll();
    }

    public Party patchParty(Long partyId, Party updatedParty) {
        Party existingParty = partyRepo.findById(partyId).orElseThrow(() -> new ResourceNotFoundException("Party not found with id: " + partyId));

        if (updatedParty.getPartyRoleType() != null) existingParty.setPartyRoleType(updatedParty.getPartyRoleType());
        if (updatedParty.getStatus() != null) existingParty.setStatus(updatedParty.getStatus());
        if (updatedParty.getThruDate() != null) existingParty.setThruDate(updatedParty.getThruDate());

        return partyRepo.save(existingParty);
    }

    public void deleteParty(Long partyId){
        if (!partyRepo.existsById(partyId)) throw new ResourceNotFoundException("Party not found with id: " + partyId);
        partyRepo.deleteById(partyId);
    }
}
