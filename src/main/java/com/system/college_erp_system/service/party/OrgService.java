package com.system.college_erp_system.service.party;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.Org;
import com.system.college_erp_system.model.party.Person;
import com.system.college_erp_system.repo.party.OrgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgService {
    @Autowired
    private OrgRepo orgRepo;

    public Org createOrg(Org org){
        return orgRepo.save(org);
    }
    public Org getOrg(Long partyId){
        return orgRepo.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Org not found with id: " + partyId));
    }
    public List<Org> getAllOrg(){
        return orgRepo.findAll();
    }
    public Org putOrg(Long partyId,Org org){
        if(!orgRepo.existsById(partyId)){
            throw new ResourceNotFoundException("Org not found with id: " + partyId);
        }
        return orgRepo.save(org);
    }
    public Org patchParty(Long partyId,Org org){
        Org existingOrg=orgRepo.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Org not found with id: " + partyId));

        if(org.getOrgName()!=null){
            existingOrg.setOrgName(org.getOrgName());
        }
        if(org.getOrgGroupSize()!=null) {
            existingOrg.setOrgGroupSize(org.getOrgGroupSize());
        }
        return orgRepo.save(existingOrg);
    }
    public void deleteOrg(Long partyId){
        if(!orgRepo.existsById(partyId)){
            throw new ResourceNotFoundException("Org not found with id: " + partyId);
        }
        orgRepo.deleteById(partyId);
    }
}
