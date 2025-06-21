package com.system.college_erp_system.model.party;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
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
    @JoinColumn(name = "contact_mech_id")
    private ContactMech contactMech;

    @NotNull
    private String address_1;

    private String address_2;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String country;
}
