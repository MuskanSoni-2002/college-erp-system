package com.system.college_erp_system.service.party;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.Faculty;
import com.system.college_erp_system.repo.party.FacultyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    private FacultyRepo facultyRepo;
    public Faculty createFaculty(Faculty faculty){
        return facultyRepo.save(faculty);
    }
    public Faculty getFacultyDetails(Long partyId){
        return facultyRepo.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Org not found with id: " + partyId));
    }
    public List<Faculty> getAllFaculties(){
        return facultyRepo.findAll();
    }
    public Faculty putFaculty(Long partyId,Faculty faculty){
        if(!facultyRepo.existsById(partyId))
            throw new ResourceNotFoundException("Org not found with id: " + partyId);
        return facultyRepo.save(faculty);
    }
    public Faculty patchFaculty(Long partyId, Faculty faculty){
        Faculty existingfaculty=facultyRepo.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Org not found with id: " + partyId));

        if(faculty.getDesignation()!=null) existingfaculty.setDesignation(faculty.getDesignation());
        if(faculty.getSubjects()!=null) existingfaculty.setSubjects(faculty.getSubjects());

        return facultyRepo.save(existingfaculty);
    }
    public void deleteFaculty(Long partyId){
        if(!facultyRepo.existsById(partyId))
            throw new ResourceNotFoundException("Org not found with id: " + partyId);

    }
}
