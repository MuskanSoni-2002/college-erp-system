package com.system.college_erp_system.model.party.contactMech;

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
        name = "party_contact_mech",
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_id", "contact_mech_id", "contact_mech_purpose_id", "from_date"})
)
public class PartyContactMech {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyContactMechId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contact_mech_id")
    private ContactMech contactMech;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contact_mech_purpose_id", referencedColumnName = "enum_id")
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
