package com.system.college_erp_system.model.party;

import com.system.college_erp_system.model.categorization.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

      @Id
      private Long partyId;
      @MapsId
      @JoinColumn(name = "partyId")
      private Party party;

      @Column(nullable = false)
      private Long rollNumber;

      @Column(nullable = false)
      private String enrollNumber;

      @Column(nullable = false)
      private String course;

      @Column(nullable = false)
      private String sem;

      private Enumeration section;

      @Column(nullable = false)
      private String session;

      @CreatedDate
      @Column(updatable = false)
      private LocalDateTime createdDate;

      @LastModifiedDate
      @Column(nullable = false)
      private LocalDateTime updatedDate;

}
