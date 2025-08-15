package com.system.college_erp_system.service.party.contactMech;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.contactMech.PhoneNumber;
import com.system.college_erp_system.repo.party.contactMech.PhoneNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberService {
    @Autowired
    private PhoneNumberRepo phoneNumberRepo;

    public PhoneNumber createPhoneNumber(PhoneNumber phoneNumber){
        return phoneNumberRepo.save(phoneNumber);
    }

    public PhoneNumber putPhoneNumber(Long contactMechId,PhoneNumber updatedPhoneNumber){
        if (!phoneNumberRepo.existsById(contactMechId)) {
            throw new ResourceNotFoundException("PhoneNumber not found with id: " + contactMechId);
        }
        return phoneNumberRepo.save(updatedPhoneNumber);
    }

    public PhoneNumber getPhoneNumber(Long contactMechId){
        return phoneNumberRepo.findById(contactMechId)
                .orElseThrow(() -> new ResourceNotFoundException("PhoneNumber not found with id: " + contactMechId));
    }

    public List<PhoneNumber> getAllParties(){
        return phoneNumberRepo.findAll();
    }

    public PhoneNumber patchPhoneNumber(Long contactMechId, PhoneNumber updatedPhoneNumber){

        PhoneNumber existingPhoneNumber=phoneNumberRepo.findById(contactMechId)
                .orElseThrow(() -> new ResourceNotFoundException("PhoneNumber not found with id: " + contactMechId));

        if(updatedPhoneNumber.getCountryCode()!=null){
            existingPhoneNumber.setCountryCode(updatedPhoneNumber.getCountryCode());
        }
        if(updatedPhoneNumber.getPhoneNumber()!=null){
            existingPhoneNumber.setPhoneNumber(updatedPhoneNumber.getPhoneNumber());
        }

        return phoneNumberRepo.save(existingPhoneNumber);
    }

    public void deletePhoneNumber(Long contactMechId){
        if (!phoneNumberRepo.existsById(contactMechId)) {
            throw new ResourceNotFoundException("PhoneNumber not found with id: " + contactMechId);
        }
        phoneNumberRepo.deleteById(contactMechId);
    }
}
