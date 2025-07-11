package com.system.college_erp_system.service.party;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.Person;
import com.system.college_erp_system.repo.party.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public Person getPerson(Long partyId){
        return personRepo.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party not found with id: " + partyId));
    }
    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }
    public Person saveOrUpdate(Person person){
        if(person.getPartyId()!=null && !personRepo.existsById(person.getPartyId())){
            throw new ResourceNotFoundException("Party with ID " + person.getPartyId() + " does not exist.");
        }
        return personRepo.save(person);
    }
    public Person patchPerson(Long partyId, Person updatedPerson){
        Person existingPerson=personRepo.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Party not found with id: " + partyId));

        if(updatedPerson.getFirstName()!=null){
            existingPerson.setFirstName(updatedPerson.getFirstName());
        }
        if(updatedPerson.getMiddleName()!=null){
            existingPerson.setMiddleName(updatedPerson.getMiddleName());
        }
        if(updatedPerson.getLastName()!=null){
            existingPerson.setLastName(updatedPerson.getLastName());
        }
        if(updatedPerson.getDob()!=null){
            existingPerson.setDob(updatedPerson.getDob());
        }
        if(updatedPerson.getGender()!=null){
            existingPerson.setGender(updatedPerson.getGender());
        }
         return personRepo.save(existingPerson);
    }
    public void deleteParty(Long partyId){
        if (!personRepo.existsById(partyId)) {
            throw new ResourceNotFoundException("Party not found with id: " + partyId);
        }
        personRepo.deleteById(partyId);
    }
}
