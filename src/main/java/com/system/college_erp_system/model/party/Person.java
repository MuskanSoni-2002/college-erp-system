package com.system.college_erp_system.model.party;

import jakarta.persistence.*;
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

    private Long enrollment_no;
    private String first_name;
    private String middle_name;
    private String last_name;
    private Date dob;
    private String gender;

}
