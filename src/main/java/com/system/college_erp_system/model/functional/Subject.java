package com.system.college_erp_system.model.functional;

import com.system.college_erp_system.model.categorization.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(
        name = "subject",
        uniqueConstraints = @UniqueConstraint(columnNames = {"subjectName", "courseId", "semesterId"})
)
public class Subject {
    @Id
    private String subjectCode;
    @NotNull
    private String subjectName;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "courseId", referencedColumnName = "enumId")
    private Enumeration course;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "semesterId", referencedColumnName = "enumId")
    private Enumeration semester;

    private Integer credits;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
