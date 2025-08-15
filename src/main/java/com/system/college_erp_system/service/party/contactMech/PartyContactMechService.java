package com.system.college_erp_system.service.party.contactMech;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.contactMech.ContactMech;
import com.system.college_erp_system.model.party.contactMech.PartyContactMech;
import com.system.college_erp_system.repo.party.contactMech.ContactMechRepo;
import com.system.college_erp_system.repo.party.contactMech.PartyContactMechRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PartyContactMechService {
    @Autowired
    private PartyContactMechRepo partyContactMechRepo;
    public PartyContactMech createPartyContactMech(PartyContactMech ContactMech){
        return partyContactMechRepo.save(ContactMech);
    }

    public PartyContactMech getPartyContactMech(Long partyContactMechId){
        return partyContactMechRepo.findById(partyContactMechId)
                .orElseThrow(() -> new ResourceNotFoundException("PartyContactMech not found with id: " + partyContactMechId));
    }
    public List<PartyContactMech> getAllPartyContactMechs(){
        return partyContactMechRepo.findAll();
    }
    public PartyContactMech putContactMech(Long partyContactMechId,PartyContactMech contactMech){
        if(!partyContactMechRepo.existsById(partyContactMechId)){
            throw new ResourceNotFoundException("ContactMech with ID " + contactMech.getContactMech() + " does not exist.");
        }
        return partyContactMechRepo.save(contactMech);
    }
    public PartyContactMech patchPartyContactMech(Long partyContactMechId, PartyContactMech updatedContactMech){
        PartyContactMech existingPartyContactMech=partyContactMechRepo.findById(partyContactMechId)
                .orElseThrow(() -> new ResourceNotFoundException("PartyContactMech not found with id: " + partyContactMechId));

        if(updatedContactMech.getThruDate()!=null){
            existingPartyContactMech.setThruDate(updatedContactMech.getThruDate());
        }
        return partyContactMechRepo.save(existingPartyContactMech);
    }
    public void deletePartyContactMech(Long partyContactMechId){
        if (!partyContactMechRepo.existsById(partyContactMechId)) {
            throw new ResourceNotFoundException("ContactMech not found with id: " + partyContactMechId);
        }
        LocalDateTime now = LocalDateTime.now();
        PartyContactMech pcm = new PartyContactMech();
        pcm.setThruDate(now);
        this.patchPartyContactMech(partyContactMechId, pcm);
//        partyContactMechRepo.deleteById(partyContactMechId);
    }
}
