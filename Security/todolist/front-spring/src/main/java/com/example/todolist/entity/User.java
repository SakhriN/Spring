package com.example.todolist.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.*;

@Entity
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String mail;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn
    Role role;

    private boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Récupérez le nom du rôle de l'utilisateur à partir de l'entité Role
        String roleName = role.getName();

        // Créez un objet SimpleGrantedAuthority à partir du nom du rôle
        GrantedAuthority authority = new SimpleGrantedAuthority(roleName);

        // Retournez l'autorité dans une liste (ou un ensemble si nécessaire)
        return Set.of(authority); // Utilisation de Set.of() pour créer un ensemble d'une seule autorité
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

}

