package com.alisayar.springjwt.entity;

import com.alisayar.springjwt.utils.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User{
    @Id
    private Long id;

    private String name;
    private String lastName;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    Role role;


}
