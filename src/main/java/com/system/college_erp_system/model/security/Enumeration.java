package com.system.college_erp_system.model.security;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enumeration {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long enum_id;

    @NotNull
    private String enum_type_id;
    @NotNull
    private String enum_value;
    private String description;
}
