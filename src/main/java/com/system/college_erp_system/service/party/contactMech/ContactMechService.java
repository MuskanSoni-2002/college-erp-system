package com.system.college_erp_system.service.party.contactMech;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.contactMech.ContactMech;
import com.system.college_erp_system.repo.party.contactMech.ContactMechRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  ContactMechService {
    private ContactMechRepo mechRepo;

    public Long createContactMech(ContactMech ContactMech){
        ContactMech contactMech = mechRepo.save(ContactMech);
        return contactMech.getContactMechId();
    }

    public ContactMech getContactMech(Long contactMechId){
        return mechRepo.findById(contactMechId)
                .orElseThrow(() -> new ResourceNotFoundException("ContactMech not found with id: " + contactMechId));
    }
    public List<ContactMech> getAllContactMechs(){
        return mechRepo.findAll();
    }
    public ContactMech putContactMech(Long contactMechId,ContactMech contactMech){
        if(!mechRepo.existsById(contactMechId)){
            throw new ResourceNotFoundException("ContactMech with ID " + contactMech.getContactMechId() + " does not exist.");
        }
        return mechRepo.save(contactMech);
    }
    public ContactMech patchContactMech(Long contactMechId, ContactMech updatedContactMech){
        ContactMech existingContactMech=mechRepo.findById(contactMechId)
                .orElseThrow(() -> new ResourceNotFoundException("ContactMech not found with id: " + contactMechId));

        if(updatedContactMech.getEmailString()!=null){
            existingContactMech.setEmailString(updatedContactMech.getEmailString());
        }
        return mechRepo.save(existingContactMech);
    }
}
