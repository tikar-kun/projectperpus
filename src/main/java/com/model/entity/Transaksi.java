package com.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_transaksi")
public class Transaksi {
    @Id
    @Column(name = "kode_transaksi")
    private String kodeTransaksi;

    @Column(name = "tanggal_pinjam")
    private Date tanggalPinjam;
    @Column(name = "tanggal_kembali")
   private Date tanggalKembali;
    @OneToOne
    @JoinColumn (name = "kode_denda", nullable = false)
    private Denda kodeDenda;

    public Denda getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(Denda kodeDenda) {
        this.kodeDenda = kodeDenda;
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }


    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }
}
