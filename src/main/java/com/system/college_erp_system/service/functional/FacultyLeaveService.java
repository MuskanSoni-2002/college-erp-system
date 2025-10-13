package com.system.college_erp_system.service.functional;

import com.system.college_erp_system.exception.ResourceNotFoundException;
import com.system.college_erp_system.model.functional.FacultyLeave;
import com.system.college_erp_system.repo.functional.FacultyLeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyLeaveService {
    @Autowired
    private FacultyLeaveRepo facultyLeaveRepo;
    public Long createFacultyLeave(FacultyLeave FacultyLeave){
         FacultyLeave fl=facultyLeaveRepo.save(FacultyLeave);
         return fl.getLeaveId();
    }

    public FacultyLeave putFacultyLeave(Long leaveId,FacultyLeave updatedFacultyLeave){
        if (!facultyLeaveRepo.existsById(leaveId)) {
            throw new ResourceNotFoundException("FacultyLeave not found with id: " + leaveId);
        }
        return facultyLeaveRepo.save(updatedFacultyLeave);
    }

    public FacultyLeave getFacultyLeave(Long leaveId){
        return facultyLeaveRepo.findById(leaveId)
                .orElseThrow(() -> new ResourceNotFoundException("FacultyLeave not found with id: " + leaveId));
    }

    public List<FacultyLeave> getAllLeaves(){
        return facultyLeaveRepo.findAll();
    }

    public FacultyLeave patchFacultyLeave(Long leaveId, FacultyLeave updatedFacultyLeave) {
        FacultyLeave existingFacultyLeave = facultyLeaveRepo.findById(leaveId)
                .orElseThrow(() -> new ResourceNotFoundException("FacultyLeave not found with id: " + leaveId));

        if (updatedFacultyLeave.getStatus() != null) existingFacultyLeave.setStatus(updatedFacultyLeave.getStatus());

        return facultyLeaveRepo.save(existingFacultyLeave);
    }

    public void deleteFacultyLeave(Long leaveId){
        if (!facultyLeaveRepo.existsById(leaveId)) throw new ResourceNotFoundException("FacultyLeave not found with id: " + leaveId);
    }
}
