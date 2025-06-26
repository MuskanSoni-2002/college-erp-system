package com.system.college_erp_system.model.categorization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
        name = "enumeration",
        uniqueConstraints = @UniqueConstraint(columnNames = {"enumTypeId", "enumValue_1"})
)
public class Enumeration {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long enumId;

    @NotNull
    private String enumTypeId;

    @NotNull
    private String enumValue_1;
    private String enumValue_2;
    private String description;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
