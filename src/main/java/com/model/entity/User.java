package com.model.entity;

import javax.persistence.*;

@Entity
@Table (name = "t_register")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long iduser;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "role", nullable = false, length = 6)
    private String roleas;

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoleas() {
        return roleas;
    }

    public void setRoleas(String roleas) {
        this.roleas = roleas;
    }
}
