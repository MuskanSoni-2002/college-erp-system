package com.system.college_erp_system.model.party;

import com.system.college_erp_system.model.config.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long party_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_type_id", referencedColumnName = "enum_id")
    private Enumeration party_type_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "enum_id")
    private Enumeration status;

    @NotNull
    private Date from_date;
    private Date thru_date;

}
