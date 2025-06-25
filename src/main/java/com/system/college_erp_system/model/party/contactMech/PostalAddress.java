package com.system.college_erp_system.model.party.contactMech;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;
}
