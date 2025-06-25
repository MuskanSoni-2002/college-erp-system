package com.system.college_erp_system.model.party.role;

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
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_role_id_from", "party_role_id_to", "from_date"})
)
public class PartyRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyRelationshipId;

    @ManyToOne
    @JoinColumn(name = "party_role_id_from", referencedColumnName = "party_role_id")
    private PartyRole partyRoleFrom;

    @ManyToOne
    @JoinColumn(name = "party_role_id_to", referencedColumnName = "party_role_id")
    private PartyRole partyRoleTo;

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
