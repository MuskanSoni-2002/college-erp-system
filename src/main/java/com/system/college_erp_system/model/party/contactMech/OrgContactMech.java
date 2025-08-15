package com.system.college_erp_system.model.party.contactMech;

import com.system.college_erp_system.model.categorization.Enumeration;
import com.system.college_erp_system.model.party.Org;
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
        name = "org_contact_mech",
        uniqueConstraints = @UniqueConstraint(columnNames = {"orgId", "contactMechId", "contactMechPurposeId", "fromDate"})
)
public class OrgContactMech {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orgContactMechId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "orgId")
    private Org org;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contactMechId")
    private ContactMech contactMech;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contactMechPurposeId", referencedColumnName = "enumId")
    private Enumeration contactMechPurpose;

    @NotNull
    private LocalDateTime fromDate;
    private LocalDateTime thruDate;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
