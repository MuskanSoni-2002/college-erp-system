package com.system.college_erp_system.model.functional;

import com.system.college_erp_system.model.party.Party;
import com.system.college_erp_system.model.config.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FacultyLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leave_id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    private Date from_date;

    private Date thru_date;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "leave_type_id", referencedColumnName = "enum_type_id")
    private Enumeration leaveType;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "status_id", referencedColumnName = "enum_type_id")
    private Enumeration status;

    private String reason_description;
}
