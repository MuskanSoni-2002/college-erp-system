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
public class PartyContactMech {
    @Id
    private Long party_id;

    @MapsId
    @JoinColumn(name = "party_id")
    private Party party;

    @JoinColumn(name = "contact_mech_id")
    private ContactMech contactMech ;

    private String contact_mech_purpose_id;

    @NotNull
    private Date from_date;
    private Date thru_date;


}
