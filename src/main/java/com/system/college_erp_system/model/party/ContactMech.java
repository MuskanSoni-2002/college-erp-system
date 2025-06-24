package com.system.college_erp_system.model.party;

import com.system.college_erp_system.model.config.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactMech {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contact_mech_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="contact_mech_type_id", referencedColumnName = "enum_type_id")
    private Enumeration contactMechType;

    private String email_string;
}
