package com.system.college_erp_system.model.party;

import jakarta.persistence.*;
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


    private int contact_mech_id;

    private Date from_date;
    private Date thru_date;


}
