package com.system.college_erp_system.model.party;

import com.system.college_erp_system.model.categorization.Enumeration;
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
public class Org {

    @Id
    private Long partyId;
    @OneToOne
    @MapsId
    @JoinColumn(name = "partyId")
    private Party party;

    @NotNull
    @Column(nullable = false)
    private String orgName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orgType", referencedColumnName = "enumId",nullable = false)
    private Enumeration orgType;

    @Column(nullable = false)
    private Integer orgGroupSize=0;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;

    private LocalDateTime thruDate;

}
