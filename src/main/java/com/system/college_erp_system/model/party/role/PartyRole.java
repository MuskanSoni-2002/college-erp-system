package com.system.college_erp_system.model.party.role;

import com.system.college_erp_system.model.categorization.Enumeration;
import com.system.college_erp_system.model.party.Party;
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
        name = "party_role",
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_id", "party_role_type_id", "from_date"})
)
public class PartyRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyRoleId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_role_type_id", referencedColumnName = "enum_id")
    private Enumeration partyRoleType;

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
