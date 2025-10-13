package com.system.college_erp_system.model.party;

import com.system.college_erp_system.model.categorization.Enumeration;
import com.system.college_erp_system.model.functional.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Faculty {
    @Id
    private Long partyId;

    @OneToOne
    @MapsId
    @JoinColumn(name="partyId")
    private Party party;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    private LocalDateTime dob;

    private String gender;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department", referencedColumnName = "orgId",nullable = false)
    private Org department;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "designation", referencedColumnName = "enumId",nullable = false)
    private Enumeration designation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "faculty_subjects",
            joinColumns = @JoinColumn(name = "party_id", referencedColumnName = "partyId"),
            inverseJoinColumns = @JoinColumn(name = "subjectCode", referencedColumnName = "subjectCode")
    )
    private Set<Subject> subjects =new HashSet<>();

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;

}
