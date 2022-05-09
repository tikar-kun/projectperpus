package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_role")
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    private Integer id;
    @Column(name = "role", nullable = false)
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
