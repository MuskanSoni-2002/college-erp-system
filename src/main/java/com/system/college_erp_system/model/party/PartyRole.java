package com.system.college_erp_system.model.party;

import com.system.college_erp_system.model.config.Enumeration;
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
        name = "party_role",
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_id,party_role_type_id,from_date"})
)
public class PartyRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long party_role_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_role_type_id",referencedColumnName = "enum_id")
    private Enumeration partyRoleType;

    @NotNull
    private Date from_date;
    private Date thru_date;
}
