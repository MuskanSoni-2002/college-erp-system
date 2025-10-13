package com.system.college_erp_system.service.functional;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.functional.StudentMarks;
import com.system.college_erp_system.repo.functional.StudentMarksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMarksService {
    @Autowired
    private StudentMarksRepo studentMarksRepo;
    public Long createStudentMarks(StudentMarks StudentMarks){
        StudentMarks fl=studentMarksRepo.save(StudentMarks);
        return fl.getStudentMarksId();
    }

    public StudentMarks putStudentMarks(Long studentMarksId,StudentMarks updatedStudentMarks){
        if (!studentMarksRepo.existsById(studentMarksId)) {
            throw new ResourceNotFoundException("StudentMarks not found with id: " + studentMarksId);
        }
        return studentMarksRepo.save(updatedStudentMarks);
    }

    public StudentMarks getStudentMarks(Long studentMarksId){
        return studentMarksRepo.findById(studentMarksId)
                .orElseThrow(() -> new ResourceNotFoundException("StudentMarks not found with id: " + studentMarksId));
    }

    public List<StudentMarks> getAllLeave(){
        return studentMarksRepo.findAll();
    }

    public StudentMarks patchStudentMarks(Long studentMarksId, StudentMarks updatedStudentMarks) {
        StudentMarks existingStudentMarks = studentMarksRepo.findById(studentMarksId)
                .orElseThrow(() -> new ResourceNotFoundException("StudentMarks not found with id: " + studentMarksId));

        if (updatedStudentMarks.getMarksObtained() != null) existingStudentMarks.setMarksObtained(updatedStudentMarks.getMarksObtained());

        return studentMarksRepo.save(existingStudentMarks);
    }

    public void deleteStudentMarks(Long studentMarksId){
        if (!studentMarksRepo.existsById(studentMarksId)) throw new ResourceNotFoundException("StudentMarks not found with id: " + studentMarksId);
        studentMarksRepo.deleteById(studentMarksId);
    }
}
