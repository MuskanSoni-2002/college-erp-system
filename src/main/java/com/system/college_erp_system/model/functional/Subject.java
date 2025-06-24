package com.system.college_erp_system.model.functional;

import com.system.college_erp_system.model.config.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String subject_name;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "course_id", referencedColumnName = "enum_type_id")
    private Enumeration course;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "semester_id", referencedColumnName = "enum_type_id")
    private Enumeration semester;

    private Integer credits;
}
