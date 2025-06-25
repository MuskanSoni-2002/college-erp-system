package com.system.college_erp_system.model.party;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "party_relationship",
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_role_id_from","party_role_id_to,from_date"})
)
public class PartyRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long party_relationship_id;

    @ManyToOne
    @JoinColumn(name = "party_role_id_from", referencedColumnName = "party_role_id")
    private PartyRole partyRoleFrom;

    @ManyToOne
    @JoinColumn(name = "party_role_id_to", referencedColumnName = "party_role_id")
    private PartyRole partyRoleTo;

    @NotNull
    private Date from_date;

    private Date thru_date;

}
