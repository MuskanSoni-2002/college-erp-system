package com.system.college_erp_system.model.party.role;

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
public class PartyRoleDetails {

    @Id
    private Long partyRoleId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "partyRoleId")
    private PartyRole partyRole;

    private String enrollmentNo;

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "enumId")
    private Enumeration course;

    @ManyToOne
    @JoinColumn(name = "departmentId", referencedColumnName = "enumId")
    private Enumeration department;

    @ManyToOne
    @JoinColumn(name = "designationId", referencedColumnName = "enumId")
    private Enumeration designation;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
