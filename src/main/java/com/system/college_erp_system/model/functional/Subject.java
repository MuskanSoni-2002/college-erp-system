package com.system.college_erp_system.model.functional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    private Long subject_id;
    private String subject_code;
    private String subject_name;
    private String course_id;
    private Integer semester_id;
    private Integer credits;
}
