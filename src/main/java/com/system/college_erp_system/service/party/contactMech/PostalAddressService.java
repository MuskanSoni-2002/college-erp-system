package com.system.college_erp_system.service.party.contactMech;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.contactMech.PostalAddress;
import com.system.college_erp_system.repo.party.contactMech.PostalAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostalAddressService {
    @Autowired
    private PostalAddressRepo postalAddressRepo;
    
    public PostalAddress createPostalAddress(PostalAddress postalAddress){
        return postalAddressRepo.save(postalAddress);
    }

    public PostalAddress putPostalAddress(Long contactMechId,PostalAddress updatedPostalAddress){
        if (!postalAddressRepo.existsById(contactMechId)) {
            throw new ResourceNotFoundException("PostalAddress not found with id: " + contactMechId);
        }
        return postalAddressRepo.save(updatedPostalAddress);
    }

    public PostalAddress getPostalAddress(Long contactMechId){
        return postalAddressRepo.findById(contactMechId)
                .orElseThrow(() -> new ResourceNotFoundException("PostalAddress not found with id: " + contactMechId));
    }

    public List<PostalAddress> getAllAddresses(){
        return postalAddressRepo.findAll();
    }

    public PostalAddress patchPostalAddress(Long contactMechId, PostalAddress updatedPostalAddress){

        PostalAddress existingPostalAddress=postalAddressRepo.findById(contactMechId)
                .orElseThrow(() -> new ResourceNotFoundException("PostalAddress not found with id: " + contactMechId));


        if(existingPostalAddress.getThruDate()!=null)
            existingPostalAddress.setThruDate(updatedPostalAddress.getThruDate());

        return postalAddressRepo.save(existingPostalAddress);
    }

    public void deletePostalAddress(Long contactMechId){
        if (!postalAddressRepo.existsById(contactMechId)) {
            throw new ResourceNotFoundException("PostalAddress not found with id: " + contactMechId);
        }
        LocalDateTime now = LocalDateTime.now();
        PostalAddress pa = new PostalAddress();
        pa.setThruDate(now);
        this.patchPostalAddress(contactMechId, pa);
    }
}
