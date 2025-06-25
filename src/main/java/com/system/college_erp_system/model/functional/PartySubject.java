package com.system.college_erp_system.model.functional;

import com.system.college_erp_system.model.party.Party;
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
        name = "party_subject",
        uniqueConstraints = @UniqueConstraint(columnNames = {"party_id", "subject_code", "from_date"})
)
public class PartySubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partySubjectId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "subject_code")
    private Subject subject;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @NotNull
    private LocalDateTime fromDate;
    private LocalDateTime thruDate;

    @CreatedDate
    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @NotNull
    private LocalDateTime updatedDate;

}
