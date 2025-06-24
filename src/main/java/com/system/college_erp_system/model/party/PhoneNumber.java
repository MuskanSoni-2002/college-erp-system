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
public class PhoneNumber {
    @Id
    private Long contact_mech_id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "contact_mech_id")
    private ContactMech contactMech;

    @NotNull
    @Column(length = 2)
    private String country_code;

    @NotNull
    @Column(length = 10, unique = true)
    private String phone_number;

}
