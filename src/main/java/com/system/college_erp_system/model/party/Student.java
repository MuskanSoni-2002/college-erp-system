package com.system.college_erp_system.model.party;

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

public class Student {

      @Id
      private Long partyId;
      @OneToOne
      @MapsId
      @JoinColumn(name = "partyId")
      private Party party;

      @NotNull
      @Column(nullable = false,unique = true)
      private Long rollNumber;

      @NotNull
      @Column(nullable = false,unique = true)
      private String enrollNumber;

      @NotNull
      @Column(nullable = false)
      private String firstName;

      private String middleName;

      @NotNull
      @Column(nullable = false)
      private String lastName;

      private LocalDateTime dob;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name="gender",referencedColumnName = "enumId")
      private Enumeration gender;

      @NotNull
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "course", referencedColumnName = "enumId", nullable = false)
      private Enumeration course;

      @NotNull
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name="sem",referencedColumnName="enumId",nullable = false)
      private Enumeration sem;

      @NotNull
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "section", referencedColumnName = "enumId", nullable = false)
      private Enumeration section;

      @NotNull
      @Column(nullable = false)
      private String session;

      @CreatedDate
      @Column(updatable = false,nullable = false)
      private LocalDateTime createdDate;

      @LastModifiedDate
      @Column(nullable = false)
      private LocalDateTime updatedDate;

}
