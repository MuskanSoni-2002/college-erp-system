package com.system.college_erp_system.model.party.contactMech;

import com.system.college_erp_system.model.categorization.Enumeration;
import com.system.college_erp_system.model.party.Party;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
        name = "contact_mech",
        uniqueConstraints = @UniqueConstraint(columnNames = {"partyId", "contactMechTypeId", "contactMechPurposeId"})
)

public class ContactMech {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactMechId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "partyId",nullable = false)
    private Party party;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contactMechTypeId", referencedColumnName = "enumId",nullable = false)
    private Enumeration contactMechType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contactMechPurposeId", referencedColumnName = "enumId",nullable = false)
    private Enumeration contactMechPurpose;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;
}
