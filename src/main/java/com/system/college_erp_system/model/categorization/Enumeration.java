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
        uniqueConstraints = @UniqueConstraint(columnNames = {"enumType", "value"}),
        indexes = @Index(name = "idx_enum_type", columnList = "enumType")
)
public class Enumeration {
    @Id
    private String enumId;

    @Column(nullable = false)
    private String enumType;

    @Column(nullable = false)
    private String value;
    private String secondaryValue;
    private String description;

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;

}
