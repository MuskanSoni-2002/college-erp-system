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

import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Faculty {
    @Id
    private Long partyId;

    @MapsId
    @JoinColumn(name="partyId")
    private Party party;

    @JoinColumn(name = "department", referencedColumnName = "orgId")
    private Org department;

    @JoinColumn(name = "designation", referencedColumnName = "enumId")
    private Enumeration designation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "faculty_subjects",
            joinColumns = @JoinColumn(name = "party_id", referencedColumnName = "partyId"),
            inverseJoinColumns = @JoinColumn(name = "subjectCode", referencedColumnName = "subjectCode")
    )
    private Set<Subject> subjects =new HashSet<>();

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;

}
