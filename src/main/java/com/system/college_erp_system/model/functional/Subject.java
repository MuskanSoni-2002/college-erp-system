package com.system.college_erp_system.model.functional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "subject",
        uniqueConstraints = @UniqueConstraint(columnNames = {"subject_name", "course_id"})
)
public class Subject {
    @Id
    private String subject_code;
    private String subject_name;
    private String course_id;
    private Integer semester_id;
    private Integer credits;
}
