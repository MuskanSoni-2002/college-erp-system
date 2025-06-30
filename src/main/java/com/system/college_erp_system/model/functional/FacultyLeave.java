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
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
        name = "faculty_leave",
        uniqueConstraints = @UniqueConstraint(columnNames = {"partyId", "leaveTypeId", "fromDate"})
)
public class FacultyLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "partyId")
    private Party party;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "leaveTypeId", referencedColumnName = "enumId")
    private Enumeration leaveType;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "statusId", referencedColumnName = "enumId")
    private Enumeration status;

    private String reasonDescription;

    @NotNull
    private Date from_date;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
