package com.system.college_erp_system.model.functional;

import com.system.college_erp_system.model.party.Party;
import com.system.college_erp_system.model.config.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "student_attendance",
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_id", "subject_code","attendance_date"})
)
public class StudentAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendance_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    @ManyToOne
    @JoinColumn(name="subject_code")
    private Subject subject;

    @NotNull
    private Date attendance_date;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "enum_id")
    private Enumeration status;
}
