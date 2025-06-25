package com.system.college_erp_system.model.functional;

import com.system.college_erp_system.model.party.Party;
import com.system.college_erp_system.model.categorization.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
        name = "student_marks",
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_id", "subject_code", "exam_type_id", "semester_id"})
)
public class StudentMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentMarksId;

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
    @JoinColumn(name = "exam_type_id", referencedColumnName = "enum_id")
    private Enumeration examType;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "semester_id", referencedColumnName = "enum_id")
    private Enumeration semester;

    @NotNull
    private Integer marksObtained;

    private LocalDateTime examDate;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
