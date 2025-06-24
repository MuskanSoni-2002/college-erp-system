package com.system.college_erp_system.model.config;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "enumeration",
        uniqueConstraints = @UniqueConstraint(columnNames = {"enum_type_id", "enum_value_1"})
)
public class Enumeration {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long enum_id;

    @NotNull
    private String enum_type_id;

    @NotNull
    private String enum_value_1;
    private String enum_value_2;
    private String description;
}
