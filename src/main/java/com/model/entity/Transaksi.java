package com.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_transaksi")
public class Transaksi {
    @Id
    @Column(name = "kode_transaksi", length = 25)
    private String kodeTransaksi;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    @Column(name = "tanggal_pinjam")
    private Date tanggalPinjam;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Bangkok")
    @Column(name = "tanggal_kembali")
   private Date tanggalKembali;


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
