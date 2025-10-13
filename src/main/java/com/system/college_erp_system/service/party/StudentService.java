package com.system.college_erp_system.service.party;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.party.Student;
import com.system.college_erp_system.repo.party.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;
    public Student createStudent(Student student){
        return repo.save(student);
    }
    public Student getStudentDetails(Long partyId){
        return repo.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Org not found with id: " + partyId));
    }
    public List<Student> getAllStudents(){
        return repo.findAll();
    }
    public Student putStudent(Long partyId,Student student){
        if(!repo.existsById(partyId)){
            throw new ResourceNotFoundException("Org not found with id: " +partyId);
        }
        return repo.save(student);
    }
    public Student patchStudent(Long partyId,Student student){
        Student existingStudent=repo.findById(partyId)
                .orElseThrow(() -> new ResourceNotFoundException("Org not found with id: " + partyId));

        if(student.getCourse()!=null) existingStudent.setCourse(student.getCourse());
        if(student.getSem()!=null) existingStudent.setSem(student.getSem());
        if(student.getSection()!=null) existingStudent.setSection(student.getSection());

        return repo.save(existingStudent);
    }
    public void deleteStudent(Long partyId){
        if(!repo.existsById(partyId))
            throw new ResourceNotFoundException("Org not found with id: " + partyId);

    }
}
