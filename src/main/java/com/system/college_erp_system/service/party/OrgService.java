package com.system.college_erp_system.service.party;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.Faculty;
import com.system.college_erp_system.model.party.Org;
import com.system.college_erp_system.repo.party.OrgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrgService {
    @Autowired
    private OrgRepo orgRepo;

    public Org createOrg(Org org){
        return orgRepo.save(org);
    }
    public Org getOrg(Long orgId){
        return orgRepo.findById(orgId)
                .orElseThrow(() -> new ResourceNotFoundException("Org not found with id: " + orgId));
    }
    public List<Org> getAllOrgs(){
        return orgRepo.findAll();
    }
    public Org putOrg(Long orgId,Org org){
        if(!orgRepo.existsById(orgId)){
            throw new ResourceNotFoundException("Org not found with id: " + orgId);
        }
        return orgRepo.save(org);
    }
    public Org patchOrg(Long orgId,Org org){
        Org existingOrg=orgRepo.findById(orgId)
                .orElseThrow(() -> new ResourceNotFoundException("Org not found with id: " + orgId));

        if(org.getOrgGroupSize()!=null) existingOrg.setOrgGroupSize(org.getOrgGroupSize());
        if(org.getThruDate()!=null) existingOrg.setThruDate(org.getThruDate());

        return orgRepo.save(existingOrg);
    }
    public void deleteOrg(Long orgId){
        if(!orgRepo.existsById(orgId))
            throw new ResourceNotFoundException("Org not found with id: " + orgId);
        LocalDateTime now = LocalDateTime.now();
        Org org = new Org();
        org.setThruDate(now);
        this.patchOrg(orgId, org);
    }
}
