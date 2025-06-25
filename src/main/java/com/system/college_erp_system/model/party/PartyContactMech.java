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
public class PartyContactMech {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long party_contact_mech_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contact_mech_id")
    private ContactMech contactMech ;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contact_mech_purpose_id",referencedColumnName = "enum_id")
    private Enumeration enumeration;

    @NotNull
    private Date from_date;
    private Date thru_date;


}
