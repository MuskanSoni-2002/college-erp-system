package com.system.college_erp_system.model.security;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
        name = "user_login_permission_appl",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_login_id", "permission_id"})
)
public class UserLoginPermissionAppl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userLoginPermissionApplId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_login_id")
    private UserLogin userLogin;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "permission_id", referencedColumnName = "enum_id")
    private Enumeration permission;

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
