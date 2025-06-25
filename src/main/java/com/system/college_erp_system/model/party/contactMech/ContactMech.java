package com.system.college_erp_system.model.party.contactMech;

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
public class ContactMech {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactMechId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contact_mech_type_id", referencedColumnName = "enum_id")
    private Enumeration contactMechType;

    private String emailString;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;
}
