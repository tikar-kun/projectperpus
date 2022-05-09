package com.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_privilege")
public class Privilege {
    @Id
    private Long idpriv;
    private String name;

    public Long getId() {
        return idpriv;
    }

    public void setId(Long idpriv) {
        this.idpriv = idpriv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
