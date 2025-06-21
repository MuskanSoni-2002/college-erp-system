package com.system.college_erp_system.model.party;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PartyRoleDetails {

    @Id
    private Long party_role_id;
    @MapsId
    @JoinColumn(name = "party_role_id")
    private PartyRole partyRole;

    @NotNull
    @JoinColumn(name = "party_id")
    private Party party;

    private String course_id;
    private String department_id;
    private String designation_id;
}
