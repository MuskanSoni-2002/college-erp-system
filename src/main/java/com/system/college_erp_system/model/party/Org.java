package com.system.college_erp_system.model.party;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @OneToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    private String org_name;
    private Integer org_group_size;

}
