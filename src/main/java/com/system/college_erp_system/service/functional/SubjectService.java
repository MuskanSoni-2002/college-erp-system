package com.system.college_erp_system.service.functional;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.functional.Subject;
import com.system.college_erp_system.repo.functional.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;
    public String createSubject(Subject Subject){
        Subject fl=subjectRepo.save(Subject);
        return fl.getSubjectCode();
    }

    public Subject putSubject(String subjectCode,Subject updatedSubject){
        if (!subjectRepo.existsById(subjectCode)) {
            throw new ResourceNotFoundException("Subject not found with id: " + subjectCode);
        }
        return subjectRepo.save(updatedSubject);
    }

    public Subject getSubject(String subjectCode){
        return subjectRepo.findById(subjectCode)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + subjectCode));
    }

    public List<Subject> getAllLeave(){
        return subjectRepo.findAll();
    }

    public void deleteSubject(String subjectCode){
        if (!subjectRepo.existsById(subjectCode)) throw new ResourceNotFoundException("Subject not found with id: " + subjectCode);
        subjectRepo.deleteById(subjectCode);
    }
}
