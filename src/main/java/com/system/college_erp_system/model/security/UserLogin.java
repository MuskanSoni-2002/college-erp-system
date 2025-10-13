package com.system.college_erp_system.model.security;

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
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class UserLogin {
    @Id
    private String userLoginId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "partyId",nullable = false)
    private Party party;

    @NotNull
    @Column(nullable = false)
    private String password;

    private String passwordHint;

    @NotNull
    private Boolean isEnabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_login_permissions",
            joinColumns = @JoinColumn(name = "user_login_id", referencedColumnName = "userLoginId"),
            inverseJoinColumns = @JoinColumn(name = "permissionId", referencedColumnName = "enumId")
    )
    private Set<Enumeration> permissions = new HashSet<>();

    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;


}
