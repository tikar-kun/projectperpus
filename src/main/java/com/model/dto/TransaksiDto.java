package com.model.dto;

import java.util.Date;

public class TransaksiDto {
    private String kodeTransaksi;
    private Date tanggalPinjam;
    private Date tanggalKembali;
    private String kodePengguna;

    private String kodeBuku;
    private String kodeDenda;


    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(String kodePengguna) {
        this.kodePengguna = kodePengguna;
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


    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getKodeDenda() {
        return kodeDenda;
    }

    public void setKodeDenda(String kodeDenda) {
        this.kodeDenda = kodeDenda;
    }
}
