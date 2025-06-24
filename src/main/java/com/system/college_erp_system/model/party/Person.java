package com.system.college_erp_system.model.party;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private Long party_id;

    @OneToOne
    @MapsId
    @JoinColumn(name ="party_id")
    private Party party;

    @Column(unique = true)
    @NotNull
    private Long enrollment_no;
    @NotNull
    private String first_name;
    private String middle_name;
    @NotNull
    private String last_name;
    @NotNull
    private Date dob;
    @NotNull
    private String gender;

}
