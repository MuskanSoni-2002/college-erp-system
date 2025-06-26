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
public class PhoneNumber {
    @Id
    private Long contactMechId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "contactMechId")
    private ContactMech contactMech;

    @NotNull
    @Column(length = 4)
    private String countryCode;

    @NotNull
    @Column(length = 10, unique = true)
    private String phoneNumber;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
