package com.system.college_erp_system.model.party;

import com.system.college_erp_system.model.config.Enumeration;
import jakarta.persistence.*;
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
    @OneToOne
    @JoinColumn(name = "party_role_id")
    private PartyRole partyRole;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "enum_type_id")
    private Enumeration course;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "enum_type_id")
    private Enumeration department;

    @ManyToOne
    @JoinColumn(name = "designation_id", referencedColumnName = "enum_type_id")
    private Enumeration designation;

}
