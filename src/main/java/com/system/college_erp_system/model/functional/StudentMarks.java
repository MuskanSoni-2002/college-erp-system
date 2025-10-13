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

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
        name = "student_marks",
        uniqueConstraints = @UniqueConstraint(columnNames = {"partyId", "subjectCode", "examTypeId", "semesterId"})
)
public class StudentMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentMarksId;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "partyId",nullable = false)
    private Party party;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "subjectCode",nullable = false)
    private Subject subject;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "examTypeId", referencedColumnName = "enumId",nullable = false)
    private Enumeration examType;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "semesterId", referencedColumnName = "enumId",nullable = false)
    private Enumeration semester;

    @NotNull
    @Column(nullable = false)
    private Integer marksObtained;

    @ManyToOne
    @JoinColumn(name = "gradeId", referencedColumnName = "enumId")
    private Enumeration grade;

    private LocalDate examDate;

    private Integer totalMarks;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;

}
