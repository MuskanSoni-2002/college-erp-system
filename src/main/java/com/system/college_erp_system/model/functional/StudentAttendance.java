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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(
        name = "student_attendance",
        uniqueConstraints = @UniqueConstraint(columnNames = {"partyId", "subjectCode", "attendanceDate"})
)
public class StudentAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "partyId")
    private Party party;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "subjectCode")
    private Subject subject;

    @NotNull
    private LocalDateTime attendanceDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "statusId", referencedColumnName = "enumId")
    private Enumeration status;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
