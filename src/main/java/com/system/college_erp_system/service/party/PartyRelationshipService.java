package com.system.college_erp_system.service.party;
import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.Faculty;
import com.system.college_erp_system.model.party.PartyRelationship;
import com.system.college_erp_system.repo.party.PartyRelationshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PartyRelationshipService {

    @Autowired
    private PartyRelationshipRepo partyRelRepo;

    public Long createPartyRel(PartyRelationship partyRelationship){
        PartyRelationship p = partyRelRepo.save(partyRelationship);
        return p.getPartyRelationshipId();
    }

    public PartyRelationship putPartyRelation(Long partyRelationshipId,PartyRelationship updatedRelation){
        if (!partyRelRepo.existsById(partyRelationshipId)) {
            throw new ResourceNotFoundException("Party not found with id: " + partyRelationshipId);
        }
        return partyRelRepo.save(updatedRelation);
    }

    public PartyRelationship getRelation(Long partyRelationshipId){
        return partyRelRepo.findById(partyRelationshipId)
                .orElseThrow(() -> new ResourceNotFoundException("Party not found with id: " + partyRelationshipId));
    }

    public List<PartyRelationship> getAllRelations(){
        return partyRelRepo.findAll();
    }

    public PartyRelationship patchRelation(Long partyRelationshipId, PartyRelationship updatedParty) {
        PartyRelationship existingParty = partyRelRepo.findById(partyRelationshipId).orElseThrow(() -> new ResourceNotFoundException("Party not found with id: " + partyRelationshipId));

        if (updatedParty.getThruDate() != null) existingParty.setThruDate(updatedParty.getThruDate());

        return partyRelRepo.save(existingParty);
    }

    public void deleteRelation(Long partyRelationshipId){
        if (!partyRelRepo.existsById(partyRelationshipId)) throw new ResourceNotFoundException("Party not found with id: " + partyRelationshipId);
        LocalDateTime now = LocalDateTime.now();
        PartyRelationship pr = new PartyRelationship();
        pr.setThruDate(now);
        this.patchRelation(partyRelationshipId, pr);
    }
}