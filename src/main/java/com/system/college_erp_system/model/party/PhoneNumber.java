package com.system.college_erp_system.model.party;

import jakarta.persistence.*;
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
    @JoinColumn(name = "contact_mech_id")
    private ContactMech contactMech;

    @Column(length = 2)
    private String country_code;
    private int phone_number;

}
