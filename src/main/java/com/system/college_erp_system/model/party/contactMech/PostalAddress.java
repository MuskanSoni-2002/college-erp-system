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
    private Long contactMechId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "contactMechId")
    private ContactMech contactMech;

    @NotNull
    @Column(length = 100,nullable = false)
    private String addressLine1;

    @Column(length = 50)
    private String addressLine2;

    @NotNull
    @Column(length = 10, nullable = false)
    private String postalCode;

    @NotNull
    @Column(length = 50,nullable = false)
    private String city;

    @NotNull
    @Column(length = 50,nullable = false)
    private String state;

    @NotNull
    @Column(length = 50,nullable = false)
    private String country;

    private LocalDateTime thruDate;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;
}
