package ru.kors.springsecurityexample.models;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Transient;

@Data
@Entity
@Table(name = "users")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    private String roles;

    @Transient
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRoles() {
        return roles;
    }

    public void setPassword(String encode) {
        password = encode;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setRoles(String roleUser) {
        roles=roleUser;
    }

    public Long getId() {
        return id;
    }
}
