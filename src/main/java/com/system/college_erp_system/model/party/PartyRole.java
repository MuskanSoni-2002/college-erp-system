package com.system.college_erp_system.model.party;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyRole {
    @Id
    private Long party_id;

    @MapsId
    @JoinColumn(name = "party_id")
    private Party party;

    private String party_role_type_id;
    private String course_id;
    private String department_id;
    private String designation_id;
    private Date from_date;
    private Date thru_date;
}
