package com.system.college_erp_system.model.party;

import com.system.college_erp_system.model.categorization.Enumeration;
import com.system.college_erp_system.model.enums.PartyRoleType;
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
        name = "party_relationship",
        uniqueConstraints = @UniqueConstraint(columnNames = {"partyFrom", "partyTo", "fromDate"})
)
public class PartyRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyRelationshipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="partyFrom",referencedColumnName = "partyId")
    private Party partyFrom;

    @Enumerated(EnumType.STRING)
    private PartyRoleType partyRoleFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="partyTo",referencedColumnName = "partyId")
    private Party partyTo;

    @Enumerated(EnumType.STRING)
    private PartyRoleType partyRoleTo;

    @Column(nullable = false)
    private LocalDateTime fromDate;

    private LocalDateTime thruDate;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;

}
