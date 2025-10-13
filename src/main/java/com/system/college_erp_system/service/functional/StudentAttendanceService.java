package com.system.college_erp_system.service.functional;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.functional.StudentAttendance;
import com.system.college_erp_system.repo.functional.StudentAttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAttendanceService {
    @Autowired
    private StudentAttendanceRepo studAttendRepo;
    public Long createStudentAttendance(StudentAttendance studentAttendance){
        StudentAttendance sa=studAttendRepo.save(studentAttendance);
        return sa.getAttendanceId();
    }

    public StudentAttendance putStudentAttendance(Long attendanceId,StudentAttendance updatedStudentAttendance){
        if (!studAttendRepo.existsById(attendanceId)) {
            throw new ResourceNotFoundException("StudentAttendance not found with id: " + attendanceId);
        }
        return studAttendRepo.save(updatedStudentAttendance);
    }

    public StudentAttendance getStudentAttendance(Long attendanceId){
        return studAttendRepo.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("StudentAttendance not found with id: " + attendanceId));
    }

    public List<StudentAttendance> getAllLeave(){
        return studAttendRepo.findAll();
    }

    public StudentAttendance patchStudentAttendance(Long attendanceId, StudentAttendance updatedStudentAttendance) {
        StudentAttendance existingStudentAttendance = studAttendRepo.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("StudentAttendance not found with id: " + attendanceId));

        if (updatedStudentAttendance.getStatus() != null) existingStudentAttendance.setStatus(updatedStudentAttendance.getStatus());

        return studAttendRepo.save(existingStudentAttendance);
    }

    public void deleteStudentAttendance(Long attendanceId){
        if (!studAttendRepo.existsById(attendanceId)) throw new ResourceNotFoundException("StudentAttendance not found with id: " + attendanceId);
        studAttendRepo.deleteById(attendanceId);
    }
}
