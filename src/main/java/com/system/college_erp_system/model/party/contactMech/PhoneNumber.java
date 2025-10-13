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
@Table(indexes = @Index(name = "idx_phone_number", columnList = "phoneNumber"))
public class PhoneNumber {
    @Id
    private Long contactMechId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "contactMechId")
    private ContactMech contactMech;

    @NotNull
    @Column(length = 4,nullable = false)
    private String countryCode;

    @NotNull
    @Column(length = 10, unique = true,nullable = false)
    private String Number;

    private LocalDateTime thruDate;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;

}
