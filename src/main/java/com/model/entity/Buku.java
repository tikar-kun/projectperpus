package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_buku")
public class Buku {
    @Id
    @Column(name = "kode_buku",length = 25)
    private String kodeBuku;

    @Column(name = "judul_buku")
    private String judulBuku;

    @Column(name = "penulis")
    private String penulis;

    @Column(name = "penerbit")
    private String penerbit;

    @Column(name = "stok")
    private int stok;

    @ManyToOne
    @JoinColumn(name = "kode_transbuku")
    private Transbuku transbuku;

    public Transbuku getTransbuku() {
        return transbuku;
    }

    public void setTransbuku(Transbuku transbuku) {
        this.transbuku = transbuku;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
