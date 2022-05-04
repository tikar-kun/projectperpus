package com.model.dto;

import java.util.Date;

public class TransaksiDto {
    private String kode;
    private Date tanggalPinjam;
    private Date tanggalKembali;
    private String kodePengguna;

    private String kodeBuku;
    private String kodeDenda;
    private Integer besarDenda;


    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
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

    public Integer getBesarDenda() {
        return besarDenda;
    }

    public void setBesarDenda(Integer besarDenda) {
        this.besarDenda = besarDenda;
    }
}
