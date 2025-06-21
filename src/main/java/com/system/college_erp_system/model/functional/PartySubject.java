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
@Table(
        name = "party_subject",
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_id", "subject_id","from_date"})
)
public class PartySubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long party_subject_id;

    @JoinColumn(name = "subject_id")
    private Subject subject;

    @JoinColumn(name = "party_id")
    private Party party;

    private Date from_date ;
    private Date thru_date;

}
