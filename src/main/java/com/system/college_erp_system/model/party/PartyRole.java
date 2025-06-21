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
public class PartyRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long party_role_id;

    @NotNull
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    private String party_role_type_id;

    @NotNull
    private Date from_date;
    private Date thru_date;
}
