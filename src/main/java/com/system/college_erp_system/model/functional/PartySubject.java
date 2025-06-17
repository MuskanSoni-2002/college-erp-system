package com.system.college_erp_system.model.functional;

import com.system.college_erp_system.model.party.Party;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartySubject {
    @EmbeddedId
    //private PartySubjectId id;

    @MapsId
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @MapsId
    @JoinColumn(name = "party_id")
    private Party party;

    private Date from_date ;
    private Date thru_date;

}
