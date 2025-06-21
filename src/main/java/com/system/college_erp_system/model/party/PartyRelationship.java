package com.system.college_erp_system.model.party;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long party_relationship_id;

    @NotNull
    private String party_id_from;

    @NotNull
    private String role_type_id_from;

    @NotNull
    private String party_id_to;

    @NotNull
    private String role_type_id_to;

    @NotNull
    private Date from_date;

}
