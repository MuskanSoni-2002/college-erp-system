package com.system.college_erp_system.model.functional;

import com.system.college_erp_system.model.party.Party;
import com.system.college_erp_system.model.config.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "student_marks",
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_id", "subject_code","exam_type_id"})
)
public class StudentMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_marks_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "subject_code")
    private Subject subject;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "exam_type_id", referencedColumnName = "enum_type_id")
    private Enumeration examType;


    @NotNull
    private Integer marks_obtained;

    private Date exam_date;

}
