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
        uniqueConstraints = @UniqueConstraint(columnNames = {"partyRoleIdFrom", "partyRoleIdTo", "fromDate"})
)
public class PartyRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyRelationshipId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PartyRoleType partyRoleTypeFrom;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PartyRoleType partyRoleTypeTo;

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
