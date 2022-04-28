package com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_ebook")
public class Ebook {
    @Id
    @Column(name = "id_ebook",length = 25)
    private String idEbook;

    @Column(name = "judul_ebook")
    private String judulEbook;

    @Column(name = "penulis")
    private String penulisEbook;

    @Column(name = "penerbit")
    private String penerbitEbook;

    @Column(name = "tahun_terbit")
    private Integer tahunTerbit;

    @Column(name = "edisi")
    private Integer edisi;

    @Column(name = "isbn")
    private Integer noISBN;

    @Column(name = "jumlah_halaman")
    private Integer jumlahHalaman;

    public String getIdEbook() {
        return idEbook;
    }
    public void setIdEbook(String idEbook) {
        this.idEbook = idEbook;
    }

    public String getJudulEbook() {
        return judulEbook;
    }
    public void setJudulEbook(String judulEbook) {
        this.judulEbook = judulEbook;
    }

    public String getPenulisEbook() {
        return penulisEbook;
    }
    public void setPenulisEbook(String penulisEbook) {
        this.penulisEbook = penulisEbook;
    }

    public String getPenerbitEbook() {
        return penerbitEbook;
    }
    public void setPenerbitEbook(String penerbitEbook) {
        this.penerbitEbook = penerbitEbook;
    }

    public Integer getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(Integer tahunTerbit) { this.tahunTerbit = tahunTerbit; }

    public Integer getEdisi() { return edisi; }
    public void setEdisi(Integer edisi) { this.edisi = edisi; }

    public Integer getNoISBN() { return noISBN; }
    public void setNoISBN(Integer noISBN) { this.noISBN = noISBN; }

    public Integer getJumlahHalaman() {
        return jumlahHalaman;
    }
    public void setJumlahHalaman(Integer jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }

}
