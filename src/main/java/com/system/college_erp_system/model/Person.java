package com.system.college_erp_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @OneToOne
    @MapsId
    @JoinColumn(name ="party_id")

    private long enrollment_no;
    private String first_name;
    private String middle_name;
    private String last_name;
    private Date dob;
    private String gender;

}
