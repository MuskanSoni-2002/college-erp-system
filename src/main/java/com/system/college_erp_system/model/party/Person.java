package com.system.college_erp_system.model.party;

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
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Person {

    @Id
    private Long party_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "partyId")
    private Party party;

    @Column(unique = true)
    @NotNull
    private Long enrollmentNo;
    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;
    @NotNull
    private LocalDateTime dob;
    private String gender;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
