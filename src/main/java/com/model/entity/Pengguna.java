package com.model.entity;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="t_pengguna")

public class Pengguna {
    @Id
    @Column(name="kd_pengguna", length = 25)
    private String kodePengguna;

    @Column(name="nama_depan")
    private String firstName;

    @Column(name = "nama_belakang")
    private String lastName;

    @Column(name="peran")
    private String peranPengguna;

    @Column(name="alamat")
    private String alamat;

    public String getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(String kodePengguna) {
        this.kodePengguna = kodePengguna;
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

    public String getPeranPengguna() {
        return peranPengguna;
    }

    public void setPeranPengguna(String peranPengguna) {
        this.peranPengguna = peranPengguna;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
