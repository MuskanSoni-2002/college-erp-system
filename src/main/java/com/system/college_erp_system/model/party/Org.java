package com.system.college_erp_system.model.party;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Org {

    @Id
    private Long party_id;

    @MapsId
    @JoinColumn(name = "party_id")
    private Party party;

    private String org_name;
    private int org_group_size;

}
