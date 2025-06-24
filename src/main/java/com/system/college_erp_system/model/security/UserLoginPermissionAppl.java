package com.system.college_erp_system.model.security;

import com.system.college_erp_system.model.config.Enumeration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "user_login_permission_appl",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_login_id", "permission_id"})
)

public class UserLoginPermissionAppl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_login_permission_appl_id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_login_id")
    private UserLogin userLogin;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "permission_id", referencedColumnName = "enum_type_id")
    private Enumeration permission;

    @NotNull
    private Date from_date;

    private Date thru_date;

}
