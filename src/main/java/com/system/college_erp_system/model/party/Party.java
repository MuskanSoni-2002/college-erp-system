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
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_type_id", referencedColumnName = "enum_id")
    private Enumeration partyType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "enum_id")
    private Enumeration status;

    @NotNull
    private LocalDateTime fromDate;
    private LocalDateTime thruDate;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
