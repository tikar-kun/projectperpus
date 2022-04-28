package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_buku")
public class Buku {
    @Id
    @Column(name = "id_buku",length = 25)
    private String idBuku;

    @Column(name = "judul_buku")
    private String judulBuku;

    @Column(name = "penulis")
    private String penulisBuku;

    @Column(name = "penerbit")
    private String penerbitBuku;

    @Column(name = "tahun_terbit")
    private Integer tahunTerbit;

    @Column(name = "kategori_buku")
    private String namaKategori;

    @Column(name = "jumlah_buku")
    private Integer jumlahBuku;

    @Column(name = "stok")
    private Integer stokBuku;

    @ManyToOne
    @JoinColumn(name = "rak", nullable = false)
    private Rak rak;

    public String getIdBuku() {
        return idBuku;
    }
    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }
    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenulisBuku() {
        return penulisBuku;
    }
    public void setPenulisBuku(String penulisBuku) {
        this.penulisBuku = penulisBuku;
    }

    public String getPenerbitBuku() {
        return penerbitBuku;
    }
    public void setPenerbitBuku(String penerbitBuku) {
        this.penerbitBuku = penerbitBuku;
    }

    public Integer getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(Integer tahunTerbit) { this.tahunTerbit = tahunTerbit; }

    public String getNamaKategori() { return namaKategori; }
    public void setNamaKategori(String namaKategori) { this.namaKategori = namaKategori; }

    public Integer getJumlahBuku() { return jumlahBuku; }
    public void setJumlahBuku(Integer jumlahBuku) { this.jumlahBuku = jumlahBuku; }

    public Integer getStokBuku() {
        return stokBuku;
    }
    public void setStokBuku(Integer stokBuku) { this.stokBuku = stokBuku; }

    public Rak getRak() {return rak;}
    public void setRak(Rak rak) {this.rak = rak;}

}
