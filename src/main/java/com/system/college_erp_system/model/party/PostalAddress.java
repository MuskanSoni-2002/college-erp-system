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
public class PostalAddress {
    @Id
    private Long contact_mech_id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "contact_mech_id")
    private ContactMech contactMech;

    @NotNull
    @Column(length = 100)
    private String address_1;

    @Column(length = 50)
    private String address_2;

    @NotNull
    @Column(length = 50)
    private String city;

    @NotNull
    @Column(length = 50)
    private String state;

    @NotNull
    @Column(length = 50)
    private String country;
}
