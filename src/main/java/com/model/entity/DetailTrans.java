package com.model.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "detail")
public class DetailTrans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String kodeDetail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kode_pengguna", referencedColumnName = "kd_pengguna")
    private Pengguna kodePengguna;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kode_buku", referencedColumnName = "id_buku")
    private Buku idBuku;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kode_transaksi", referencedColumnName = "kode_transaksi")
    private Transaksi kodeTransaksi;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kode_denda", referencedColumnName = "kode_denda")
    private Denda kodeDenda;

    @Column(name = "jenis_transaksi")
    private String jenis;

    public String getKodeDetail() {
        return kodeDetail;
    }

    public void setKodeDetail(String kodeDetail) {
        this.kodeDetail = kodeDetail;
    }

    public Pengguna getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(Pengguna kodePengguna) {
        this.kodePengguna = kodePengguna;
    }

    public Buku getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Buku idBuku) {
        this.idBuku = idBuku;
    }

    public Transaksi getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(Transaksi kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public Denda getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(Denda kodeDenda) {
        this.kodeDenda = kodeDenda;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
