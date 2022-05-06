package com.model.entity;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="t_pengguna")

public class Pengguna {
    @Id
    @Column(name="kd_pengguna", length = 25)
    private String kodePengguna;

    @Column(name="nama_pengguna")
    private String namaPengguna;

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

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
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
