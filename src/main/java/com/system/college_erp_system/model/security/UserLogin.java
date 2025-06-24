package com.system.college_erp_system.model.security;

import com.system.college_erp_system.model.party.Party;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserLogin {
    @Id
    private String user_login_id;

    @NotNull
    @OneToOne
    @JoinColumn(name="party_id")
    private Party party;

    @NotNull
    private String password;

    @NotNull
    private Boolean is_enabled;
}
